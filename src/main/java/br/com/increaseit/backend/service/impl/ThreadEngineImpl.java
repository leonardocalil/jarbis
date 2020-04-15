package br.com.increaseit.backend.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.increaseit.backend.service.Engine;
import br.com.increaseit.common.constants.FlowFrequence;
import br.com.increaseit.common.constants.FlowStatus;
import br.com.increaseit.common.constants.FormFieldType;
import br.com.increaseit.common.constants.LogStatus;
import br.com.increaseit.common.constants.ScheduleStatus;
import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.entity.FlowLog;
import br.com.increaseit.internal.data.entity.FrequenceDateTime;
import br.com.increaseit.internal.data.entity.FrequenceWeekDay;
import br.com.increaseit.internal.data.entity.GroupAction;
import br.com.increaseit.internal.data.entity.Schedule;
import br.com.increaseit.internal.data.entity.Wait;
import br.com.increaseit.internal.data.service.impl.FlowLogService;
import br.com.increaseit.internal.data.service.impl.FlowService;

@Service("threadEngine")
public class ThreadEngineImpl implements Engine {
	@Autowired(required = false)
	private FlowService service;

	@Autowired(required = false)
	private FlowLogService logService;

	@PostConstruct
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"D:/environment/workspace_mars/primefaces/src/main/resources/webdriver/chromedriver.exe");

	}

	private Schedule getSchedule(Flow flow, ScheduleStatus status) {
		if (FlowFrequence.CYCLIC_MINUTE.equals(flow.getFrequence())) {
			if (status.equals(flow.getFrequenceInterval().getStatus())) {
				return flow.getFrequenceInterval();
			}
		} else if (FlowFrequence.CYCLIC_WEEKDAY.equals(flow.getFrequence())) {
			for (FrequenceWeekDay fwd : flow.getFrequenceWeekDay()) {
				if (status.equals(fwd.getStatus())) {
					return fwd;
				}
			}

		} else if (FlowFrequence.SCHEDULED.equals(flow.getFrequence())) {
			for (FrequenceDateTime fdt : flow.getFrequenceDateTime()) {
				if (status.equals(fdt.getStatus())) {
					return fdt;
				}
			}
		}
		return null;
	}

	@Async
	public void execute() {
		List<Flow> flows = service.findAllFinishedRecurrence();
		if (flows != null && flows.size() > 0) {
			for (Flow flow : flows) {
				Schedule schedule = getSchedule(flow, ScheduleStatus.FINISHED);
				schedule.setStatus(ScheduleStatus.WAITING);
				service.save(flow);
			}
		}
	}

	@Async
	public void execute(Flow flow) {

		if (FlowFrequence.CYCLIC_MINUTE.equals(flow.getFrequence())) {
			flow.getFrequenceInterval().setLastExecution(Calendar.getInstance().getTime());
		}
		Schedule schedule = getSchedule(flow, ScheduleStatus.WAITING);

		schedule.setStatus(ScheduleStatus.EXECUTING);
		flow.setStatus(FlowStatus.EXECUTING);
		service.save(flow);

		FlowLog log = logService.startLog(flow.getRowId(), null, null, null, null, flow.getName());

		ChromeDriver driver = new ChromeDriver();

		try {

			System.out.println("executando Thread: " + flow.toString());

			executeGroupAction(driver, flow.getGroupActions().get(0), flow.getRowId());

		} catch (Exception e) {
			log.setStatus(LogStatus.ERROR);
			log.setErrorMessage(e.getMessage());
		} finally {

			schedule.setStatus(ScheduleStatus.FINISHED);
			flow.setStatus(FlowStatus.READY);
			service.save(flow);

			logService.finishLog(log);

			driver.quit();

		}

	}

	private void executeGroupAction(final ChromeDriver driver, final GroupAction groupAction, final Long flowId) {

		final Long groupId = groupAction.getRowId();
		FlowLog log = logService.startLog(groupAction.getFlow().getRowId(), groupAction.getRowId(), null, null, null,
				groupAction.getName());

		Map<Long, String> actionReading = new HashMap<Long, String>();

		driver.manage().window().maximize();
		driver.get(groupAction.getUrl());

		for (Action action : groupAction.getActions()) {
			wait(driver, action.getPreAction(), flowId, groupId, action.getRowId());
			WebElement element = getElement(driver, action);
			doAction(element, action, flowId, groupId, actionReading);
			wait(driver, action.getPosAction(), flowId, groupId, action.getRowId());
		}

		logService.finishLog(log);

	}

	private By getLocator(FormFieldType fieldType, String fieldName) {
		switch (fieldType) {
		case ID:
			return By.id(fieldName);
		case NAME:
			return By.name(fieldName);
		case CLASS:
			return By.className(fieldName);
		}
		return By.xpath(fieldName);
	}

	private void wait(WebDriver driver, Wait waitDto, Long flowId, Long groupId, Long actionId) {
		if (waitDto != null) {
			FlowLog log = logService.startLog(flowId, groupId, actionId, waitDto.getRowId(), null, waitDto.getName());
			try {

				if (waitDto.getFieldName() == null || waitDto.getFieldName().trim().length() == 0) {
					try {
						Thread.sleep(waitDto.getTimeOut() * 1000);
					} catch (InterruptedException e) {
						log.setStatus(LogStatus.ERROR);
						log.setErrorMessage(e.getMessage());
					}
				} else {
					WebDriverWait wait = new WebDriverWait(driver, waitDto.getTimeOut());

					wait.until(ExpectedConditions
							.visibilityOfElementLocated(getLocator(waitDto.getFieldType(), waitDto.getFieldName())));

				}

			} catch (Exception e) {
				log.setStatus(LogStatus.ERROR);
				log.setErrorMessage(e.getMessage());
			} finally {
				logService.finishLog(log);
			}
		}

		// wait.until(ExpectedConditions.elementToBeClickable(By.id<locator>));
	}

	private void doAction(final WebElement element, final Action action, final Long flowId, final Long groupId,
			final Map<Long, String> actionReading) {
		FlowLog log = logService.startLog(flowId, groupId, action.getRowId(), null, null, action.getName());

		switch (action.getDoAction()) {
		case WRITE: {
			element.sendKeys(action.getParameter().getText());
		}
			;
			break;
		case READ_FIELD: {
			String result = element.findElement(getLocator(action.getFieldType(), action.getFieldName())).getText();
			log.setResultValue(result);
			actionReading.put(action.getRowId(), result);
		}
			;
			break;
		case READ_TABLE: {

		}
			;
			break;

		case CLICK: {
			element.click();
		}
			;
			break;

		}
		logService.finishLog(log);
	}

	private WebElement getElement(final WebDriver driver, final Action action) {
		return driver.findElement(getLocator(action.getFieldType(), action.getFieldName()));
	}

}
