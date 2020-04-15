package br.com.increaseit.frontend.bean.flow;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ReorderEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.util.CollectionUtils;

import br.com.increaseit.common.constants.EnumWeekDay;
import br.com.increaseit.common.constants.FlowFrequence;
import br.com.increaseit.common.constants.FormFieldAction;
import br.com.increaseit.common.constants.FormFieldDoOption;
import br.com.increaseit.common.constants.FormFieldLogicalOperator;
import br.com.increaseit.common.constants.FormFieldRelationalOperator;
import br.com.increaseit.common.constants.FormFieldType;
import br.com.increaseit.common.constants.FormFieldTypeWrite;
import br.com.increaseit.common.util.Constants;
import br.com.increaseit.common.util.Messages;
import br.com.increaseit.common.vo.DecisionActionVo;
import br.com.increaseit.common.vo.LogicalOperationVo;
import br.com.increaseit.common.vo.RelationalOperationVo;
import br.com.increaseit.frontend.bean.FrontendBean;
import br.com.increaseit.frontend.util.ApplicationContextProvider;
import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.entity.DecisionAction;
import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.entity.FrequenceDateTime;
import br.com.increaseit.internal.data.entity.FrequenceInterval;
import br.com.increaseit.internal.data.entity.FrequenceWeekDay;
import br.com.increaseit.internal.data.entity.GroupAction;
import br.com.increaseit.internal.data.entity.LogicalOperation;
import br.com.increaseit.internal.data.entity.Parameter;
import br.com.increaseit.internal.data.entity.RelationalOperation;
import br.com.increaseit.internal.data.entity.Wait;
import br.com.increaseit.internal.data.service.impl.ActionService;
import br.com.increaseit.internal.data.service.impl.DecisionActionService;
import br.com.increaseit.internal.data.service.impl.FlowService;
import br.com.increaseit.internal.data.service.impl.FrequenceDateTimeService;
import br.com.increaseit.internal.data.service.impl.FrequenceIntervalService;
import br.com.increaseit.internal.data.service.impl.FrequenceWeekDayService;
import br.com.increaseit.internal.data.service.impl.GroupActionService;

@ManagedBean(name = "flowForm")
@SessionScoped
public class FlowFormBean extends FrontendBean {

	public static final String PAGE_FORM = "flow_form.faces";

	private List<FlowFrequence> typeFrequences;
	private List<EnumWeekDay> weekDays;;

	private Flow flow;
	private FrequenceWeekDay frequenceWeekDaySelected;
	private FrequenceDateTime frequenceDateTimeSelected;
	
	private FrequenceWeekDay frequenceWeekDayForRemove;
	private FrequenceDateTime frequenceDateTimeForRemove;

	private TreeNode root;

	private TreeNode selectedNode;

	private GroupAction groupActionSelected;

	private Wait preActionSelected;
	
	private Wait posActionSelected;
	
	private Action actionSelected;

	private Action actionSelectedForRemove;

	private DecisionAction decisionSelected;

	private DecisionAction decisionSelectedForRemove;

	private LogicalOperation logicalOperationSelectedForRemove;
	private RelationalOperation operationSelectedForRemove;

	private DecisionActionService decisionActionService;
	private ActionService actionService;
	private GroupActionService groupActionService;
	private FlowService flowService;
	private FrequenceDateTimeService frequenceDateTimeService; 
	private FrequenceWeekDayService frequenceWeekDayService;
	private FrequenceIntervalService frequenceIntervalService;
	
	private Long nextGroupIdSelected;

	@PostConstruct
	public void init() {
		typeFrequences = new ArrayList<FlowFrequence>();
		typeFrequences.addAll(Arrays.asList(FlowFrequence.values()));

		this.decisionActionService = ApplicationContextProvider.getBean("decisionActionService",
				DecisionActionService.class);
		this.actionService = ApplicationContextProvider.getBean("actionService", ActionService.class);
		this.groupActionService = ApplicationContextProvider.getBean("groupActionService", GroupActionService.class);
		this.flowService = ApplicationContextProvider.getBean("flowService", FlowService.class);
		this.frequenceDateTimeService = ApplicationContextProvider.getBean("frequenceDateTimeService", FrequenceDateTimeService.class);
		this.frequenceWeekDayService = ApplicationContextProvider.getBean("frequenceWeekDayService", FrequenceWeekDayService.class);
		this.frequenceIntervalService = ApplicationContextProvider.getBean("frequenceIntervalService", FrequenceIntervalService.class);		
		
		weekDays = new ArrayList<EnumWeekDay>();
		weekDays.addAll(Arrays.asList(EnumWeekDay.values()));
		clearAll();
	}

	private void clearAll() {
		this.root = null;
		this.selectedNode = null;
		this.groupActionSelected = null;
		this.actionSelected = null;
		this.actionSelectedForRemove = null;
		this.decisionSelected = null;
		this.decisionSelectedForRemove = null;
		this.logicalOperationSelectedForRemove = null;
		this.operationSelectedForRemove = null;
		this.frequenceWeekDayForRemove = null;
		this.frequenceDateTimeForRemove = null;
		
		this.frequenceDateTimeSelected= null;
		this.frequenceWeekDaySelected = null;

		flow = new Flow();
		flow.setFrequenceInterval(newFrequenceInterval());
		
	}
	private FrequenceInterval newFrequenceInterval() {
		return new FrequenceInterval(frequenceIntervalService.getNextRowId(), this.flow);
	}

	public void editFlow(Flow flow) {
		this.flow = flow;
		if (this.flow != null) {
			this.changeFrequence();
			if (this.flow.getGroupActions().size() == 0) {

				GroupAction ga = new GroupAction(flow, null,
						Messages.getInstance().getMessage(Constants.MESSAGE_NAME_DECISION_GROUP_DEFAULT));
				ga.setRowId(this.groupActionService.getNextRowId());
				flow.getGroupActions().add(ga);
			}
			root = loadTreeNode(flow.getGroupActions().get(0), flow.getGroupActions(), null);

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(FlowFormBean.PAGE_FORM);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void addFlow() {
		clearAll();

		flow.setRowId(flowService.getNextRowId());
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(FlowFormBean.PAGE_FORM);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TreeNode loadTreeNode(final GroupAction groupAction, final List<GroupAction> groupActions,
			final TreeNode root) {
		TreeNode node = new DefaultTreeNode(groupAction, root);

		for (DecisionAction decisionAction : groupAction.getDecisions()) {
			if (decisionAction.getNextGroup() != null) {
				GroupAction nextGroup = groupActions.stream()
						.filter(ga -> ga.getRowId().equals(decisionAction.getNextGroup().getRowId())
								&& decisionAction.getRowId().equals(ga.getDecisionAction().getRowId()))
						.findFirst().orElse(null);

				if (nextGroup != null) {
					loadTreeNode(nextGroup, groupActions, node);
				}

			}
		}

		return node;
	}

	public void addStep() {
		if(!validadeAddStepDecision()) {
			return;
		}
		this.actionSelected = new Action(this.groupActionSelected);
		this.actionSelected.setRowId(actionService.getNextRowId());
		this.actionSelected.setSequence(this.groupActionSelected.getActions().size() + 1);
		this.executeScripts("PF('dialogAction').show();");
	
	}
	private boolean validadeAddStepDecision() {
		if(this.groupActionSelected.isNewObject()
				|| this.groupActionSelected.isEdited()) {
			String message = this.getMessage(Constants.MESSAGE_WARNING_GROUP_ACTION_SHOULD_BE_SAVE);
			this.addWarningMessage(message);
			return false;
		}
		return true;
	}

	public void editStep(Action action) {
		this.actionSelected = action;
		if(action != null) {
			this.preActionSelected = action.getPreAction();
			this.posActionSelected = action.getPosAction();
		}

	}

	public void removeAction() {
		this.groupActionSelected.getActions().remove(this.actionSelectedForRemove);
	}

	public void setActionForRemove(Action action) {
		this.actionSelectedForRemove = action;
	}

	public void addDecision() {
		if(!validadeAddStepDecision()) {
			return;
		}
		this.decisionSelected = new DecisionAction(this.groupActionSelected);
		this.decisionSelected.setRowId(decisionActionService.getNextRowId());
		this.decisionSelected.setSequence(this.groupActionSelected.getDecisions().size() + 1);
		this.executeScripts("PF('dialogDecision').show();");

	}

	public void editDecision(DecisionAction decision) {

		try {
			this.decisionSelected = (DecisionAction) decision.clone();
			this.nextGroupIdSelected = null;
			if (this.decisionSelected.getNextGroup() != null) {
				this.nextGroupIdSelected = this.decisionSelected.getNextGroup().getRowId();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public void removeDecision() {
		this.groupActionSelected.getDecisions().remove(this.decisionSelectedForRemove);
	}

	public void addLogicalOperator(DecisionAction decisionSelected) {
		decisionSelected.getLogicalOperations().add(new LogicalOperation(decisionSelected));
	}

	public void addRelationalOperator(LogicalOperation logicalOperation) {
		logicalOperation.getOperations().add(new RelationalOperation(logicalOperation));
	}

	public void addFrequenceDateTime() {

		if (validateNewFrequenceDateTime()) {
			this.flow.getFrequenceDateTime().add(this.frequenceDateTimeSelected);
			this.frequenceDateTimeSelected.setNewObject(false);
			
			newFrequenceDateTime();
		}

	}
	
	public void updateFrequenceDateTime() {
		
		if(validateNewFrequenceDateTime()) {
			FrequenceDateTime dateTime = this.flow.getFrequenceDateTime().stream().filter(fwd -> fwd.getRowId().equals(this.frequenceDateTimeSelected.getRowId())).findFirst().get();
			
			dateTime.setDateTime(this.frequenceDateTimeSelected.getDateTime());
			newFrequenceDateTime();
		}
		
		
	}
	
	public void newFrequenceDateTime() {
		this.frequenceDateTimeSelected = new FrequenceDateTime(frequenceDateTimeService.getNextRowId(), this.flow);
		
		
	}
	public void editFrequenceDateTime(FrequenceDateTime dateTime) {
		this.frequenceDateTimeSelected = new FrequenceDateTime(dateTime.getRowId(), 
																dateTime.getName(), 
																dateTime.getFlow(),
																dateTime.getDateTime(),
																dateTime.isActive(),
																dateTime.isNewObject());	
		
	}
	
	public void setFrequenceWeekDayForRemove(FrequenceWeekDay frequenceWeekDay) {

		this.frequenceWeekDayForRemove = frequenceWeekDay;
	}	
	
	public void removeFrequenceDateTime() {
		this.flow.getFrequenceDateTime().remove(frequenceDateTimeForRemove);
	}

	public void setLogicalOperatorForRemove(LogicalOperation logicalOperation) {
		this.logicalOperationSelectedForRemove = logicalOperation;
	}

	public void removeLogicalOperator() {
		this.decisionSelected.getLogicalOperations().remove(this.logicalOperationSelectedForRemove);
	}
	
	public void setRelationalOperatorForRemove(LogicalOperation logicalOperation, RelationalOperation operation) {
		this.logicalOperationSelectedForRemove = logicalOperation;
		this.operationSelectedForRemove = operation;
	}

	public void removeRelationalOperator() {
		this.logicalOperationSelectedForRemove.getOperations().remove(this.operationSelectedForRemove);
	}

	public void changeWeekDayStatus(FrequenceWeekDay weekDay) {
		String summary = weekDay.isActive() ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

	public void changeScheduledStatus(FrequenceDateTime scheduled) {
		String summary = scheduled.isActive() ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

	public void changeTypeAction() {
		actionSelected.setTypeWrite(null);
	}

	public void changeTypeWrite() {
		if (actionSelected == null || actionSelected.getTypeWrite() == null) {
			actionSelected.setParameter(null);
			return;
		}
		switch (actionSelected.getTypeWrite()) {
			case CONSTANT:
			case VARIABLE: {
				if (actionSelected.getParameter() == null) {
					actionSelected.setParameter(new Parameter(actionSelected));
				}
	
			};
			break;
		}
	}
	
	public void changeWaitPreAction() {
		if(this.actionSelected.getWaitPreAction()) {
			if(this.preActionSelected != null) {
				this.actionSelected.setPreAction(this.preActionSelected);
			} else {
				this.actionSelected.setPreAction(new Wait(this.actionSelected, null));
			}
		} else {
			this.preActionSelected = this.actionSelected.getPreAction();
			this.actionSelected.setPreAction(null);
		}
	}
	public void changeWaitPosAction() {
		if(this.actionSelected.getWaitPosAction()) {
			if(this.posActionSelected != null) {
				this.actionSelected.setPosAction(this.posActionSelected);
			} else {
				this.actionSelected.setPosAction(new Wait(null, this.actionSelected));
			}
		} else {
			this.preActionSelected = this.actionSelected.getPosAction();
			this.actionSelected.setPosAction(null);
		}
		
	}

	public void changeFrequence() {
		if (this.flow.getFrequence() != null) {
			switch (this.flow.getFrequence()) {
			case CYCLIC_MINUTE:

				if (this.flow.getFrequenceInterval() == null) {
					this.flow.setFrequenceInterval(newFrequenceInterval());
				} 
				break;
			case CYCLIC_WEEKDAY:
				newFrequenceWeekDay();
				break;
			case SCHEDULED:
				newFrequenceDateTime();
				break;
			}
		}
	}

	public void changeVariableGroup() {
		// List<GroupActionVo> groups = this.getGroups();
		// for (GroupActionVo group : groups) {
		// if (group.getName().equals(parameterGroup.getValue())) {
		// parameterGroup.setValue(group);
		// break;
		// }
		// }
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public void search() {

	}

	public List<FlowFrequence> getTypeFrequences() {
		return typeFrequences;
	}

	public void setTypeFrequences(List<FlowFrequence> typeFrequences) {
		this.typeFrequences = typeFrequences;
	}

	public List<EnumWeekDay> getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(List<EnumWeekDay> weekDays) {
		this.weekDays = weekDays;
	}

	

	
	public FrequenceWeekDay getFrequenceWeekDaySelected() {
		return frequenceWeekDaySelected;
	}

	public void setFrequenceWeekDaySelected(FrequenceWeekDay frequenceWeekDaySelected) {
		this.frequenceWeekDaySelected = frequenceWeekDaySelected;
	}

	public FrequenceDateTime getFrequenceDateTimeSelected() {
		return frequenceDateTimeSelected;
	}

	public void setFrequenceDateTimeSelected(FrequenceDateTime frequenceDateTimeSelected) {
		this.frequenceDateTimeSelected = frequenceDateTimeSelected;
	}

	public LogicalOperation getLogicalOperationSelectedForRemove() {
		return logicalOperationSelectedForRemove;
	}

	public void setLogicalOperationSelectedForRemove(LogicalOperation logicalOperationSelectedForRemove) {
		this.logicalOperationSelectedForRemove = logicalOperationSelectedForRemove;
	}

	public RelationalOperation getOperationSelectedForRemove() {
		return operationSelectedForRemove;
	}

	public void setOperationSelectedForRemove(RelationalOperation operationSelectedForRemove) {
		this.operationSelectedForRemove = operationSelectedForRemove;
	}

	public GroupActionService getGroupActionService() {
		return groupActionService;
	}

	public void setGroupActionService(GroupActionService groupActionService) {
		this.groupActionService = groupActionService;
	}

	public FlowService getFlowService() {
		return flowService;
	}

	public void setFlowService(FlowService flowService) {
		this.flowService = flowService;
	}

	public void setDecisionSelectedForRemove(DecisionAction decisionSelectedForRemove) {
		this.decisionSelectedForRemove = decisionSelectedForRemove;
	}

	public TreeNode getRoot() {
		root = loadTreeNode(flow.getGroupActions().get(0), flow.getGroupActions(), null);
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
		if (this.selectedNode != null) {
			this.groupActionSelected = (GroupAction) selectedNode.getData();
		}
	}

	public GroupAction getGroupActionSelected() {
		return groupActionSelected;
	}

	public void setGroupActionSelected(GroupAction groupActionSelected) {
		this.groupActionSelected = groupActionSelected;

	}

	public Action getActionSelected() {
		return actionSelected;
	}

	public void setActionSelected(Action actionSelected) {
		this.decisionSelected = null;
		this.actionSelected = actionSelected;
	}

	public DecisionAction getDecisionSelected() {
		return decisionSelected;
	}

	public void setDecisionSelected(DecisionAction decisionSelected) {
		this.actionSelected = null;
		this.decisionSelected = decisionSelected;
	}

	public FormFieldType[] getFormFieldTypes() {
		return FormFieldType.values();
	}

	public FormFieldAction[] getFormFieldActions() {
		return FormFieldAction.values();
	}

	public FormFieldTypeWrite[] getFormFieldTypeWrites() {
		return FormFieldTypeWrite.values();
	}

	public FormFieldLogicalOperator[] getFormFieldLogicalOperators() {
		return FormFieldLogicalOperator.values();
	}

	public FormFieldRelationalOperator[] getFormFieldRelationalOperators() {
		return FormFieldRelationalOperator.values();
	}

	public FormFieldDoOption[] getFormFieldDoOptions() {
		return FormFieldDoOption.values();
	}

	public List<GroupAction> getGroups() {
		List<GroupAction> result = new ArrayList<GroupAction>();
		loadGroups(flow.getGroupActions().get(0), this.groupActionSelected, result);
		return result;

	}

	public List<Action> getElegibleActions() {
		List<Action> result = new ArrayList<Action>();
		if (actionSelected != null && actionSelected.getParameter() != null) {
			for (Action action : this.groupActionSelected.getActions()) {

				if (this.actionSelected != null && action.getRowId().equals(this.actionSelected.getRowId())) {
					return result;
				}
				if (FormFieldAction.READ_FIELD.equals(action.getDoAction())
						|| FormFieldAction.READ_TABLE.equals(action.getDoAction())) {
					result.add(action);
				}
			}
		}
		return result;

	}

	public List<Action> getActionsFromGroupAction() {
		List<Action> result = new ArrayList<Action>();
		if (groupActionSelected != null) {
			result.addAll(
					groupActionSelected.getActions().stream()
							.filter(action -> FormFieldAction.READ_FIELD.equals(action.getDoAction())
									|| FormFieldAction.READ_TABLE.equals(action.getDoAction()))
							.collect(Collectors.toList()));
		}
		return result;
	}

	private boolean loadGroups(final GroupAction groupAction, final GroupAction selectedGroupAction,
			final List<GroupAction> result) {
		if (groupAction == selectedGroupAction) {
			result.add(groupAction);
			return true;
		}

		for (DecisionAction decisionAction : groupAction.getDecisions()) {

			if (decisionAction.getNextGroup() != null) {
				GroupAction nextGroup = flow.getGroupActions().stream()
						.filter(ga -> ga.getRowId().equals(decisionAction.getNextGroup().getRowId())).findAny().get();
				if (loadGroups(nextGroup, selectedGroupAction, result)) {
					result.add(groupAction);
					return true;
				}
			}

		}
		return false;

	}

	public void saveStep() {
		if (!validateStepAction()) {
			return;
		}
		boolean isNew = this.actionSelected.isNewObject();
		this.actionSelected = this.actionService.save(actionSelected);
		if(isNew) {
			this.groupActionSelected.getActions().add(this.actionSelected);
		}
		
		this.addInfoMessage(this.getMessage(Constants.MESSAGE_INFO_REGISTER_SAVE));
		this.executeScripts("PF('" + Constants.FORM_FLOW_ACTION_DIALOG + "').hide()");
		
	}

	public void saveFlow() {
		if (!validadeFlow()) {
			return;
		}

		this.flow = flowService.save(this.flow);

		if (this.flow.getGroupActions().size() == 0) {

			GroupAction ga = new GroupAction(flow, null,
					Messages.getInstance().getMessage(Constants.MESSAGE_NAME_DECISION_GROUP_DEFAULT));
			ga.setRowId(this.groupActionService.getNextRowId());
			flow.getGroupActions().add(ga);

			root = loadTreeNode(flow.getGroupActions().get(0), flow.getGroupActions(), null);
		}
		this.addInfoMessage(this.getMessage(Constants.MESSAGE_INFO_REGISTER_SAVE));

	}

	public void saveGroupActions() {
		if (!validadeGroupAction()) {
			return;	
		}

		this.groupActionSelected = groupActionService.save(this.groupActionSelected);
		this.addInfoMessage(this.getMessage(Constants.MESSAGE_INFO_REGISTER_SAVE));
		this.executeScripts("PF('" + Constants.FORM_FLOW_ACTION_DIALOG + "').hide()");
	}

	public void saveDecision() {
		if (!validateDecision()) {
			return;
		}
		if (FormFieldDoOption.GOTO_NEXT.equals(this.decisionSelected.getDoOption())) {

			if (this.decisionSelected.getNextGroup() != null) {

				GroupAction groupAction = getGroupActionFromFlowById(this.decisionSelected.getNextGroup().getRowId());
				groupAction.setDecisionAction(null);
				this.groupActionService.save(groupAction);
			}
			GroupAction nextGroupAction = null;
			if (this.nextGroupIdSelected == 0) {
				nextGroupAction = new GroupAction(this.flow, null,
						this.getMessage(Constants.MESSAGE_NAME_DECISIOUN_GROUP_DEFAULT));
				nextGroupAction.setRowId(groupActionService.getNextRowId());

				nextGroupAction = this.groupActionService.save(nextGroupAction);
				
				this.getDecisionSelected().setNextGroup(nextGroupAction);
				
				flow.getGroupActions().add(nextGroupAction);
				

			} else {
				nextGroupAction = flow.getGroupActions().stream()
						.filter(ga -> ga.getRowId().equals(this.nextGroupIdSelected)).findFirst().get();
				nextGroupAction.setDecisionAction(this.decisionSelected);								
			}
			
			this.nextGroupIdSelected = nextGroupAction.getRowId();
			decisionSelected.setNextGroup(nextGroupAction);

			this.decisionSelected = this.decisionActionService.save(this.decisionSelected);
		

			nextGroupAction.setDecisionAction(this.decisionSelected);
			nextGroupAction = this.groupActionService.save(nextGroupAction);
			
		} else {
			this.decisionSelected = this.decisionActionService.save(this.decisionSelected);
		}
		
		
		if(!this.groupActionSelected.getDecisions().contains(this.decisionSelected)) {
		
			this.groupActionSelected.getDecisions().add(this.decisionSelected);
		}
		
		this.executeScripts("PF('" + Constants.FORM_FLOW_DECISION_DIALOG + "').hide()");
		this.addInfoMessage(this.getMessage(Constants.MESSAGE_INFO_REGISTER_SAVE));
	}

	private boolean validateStepAction() {
		if (this.actionSelected == null) {
			this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_STEP_ACTION_NOT_SELECTED));
			return false;
		}
		if (this.groupActionSelected.getActions().stream().anyMatch(action -> !action.equals(actionSelected)
				&& actionSelected.getName().equalsIgnoreCase(action.getName()))) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_STEP_ACTION_NAME_ALREADY_EXISTS).replace("{}",
					actionSelected.getName());
			this.addErrorMessage(message);
			return false;
		}

		return true;
	}

	private boolean validadeFlow() {

		switch( this.flow.getFrequence()) {
			case CYCLIC_WEEKDAY: {
				if(CollectionUtils.isEmpty(this.flow.getFrequenceWeekDay())) {
					String message = this.getMessage(Constants.MESSAGE_ERROR_FLOW_FREQUENCE_AT_LEAST_ONE_WEEKDAY);
					this.addErrorMessage(message);
					return false;
				}
			} break;
			case SCHEDULED: {
				if(CollectionUtils.isEmpty(this.flow.getFrequenceDateTime())) {
					String message = this.getMessage(Constants.MESSAGE_ERROR_FLOW_FREQUENCE_AT_LEAST_ONE_DATETIME);
					this.addErrorMessage(message);
					return false;
				}
			} break;
			default:
				
		}
		
		String name = this.flow.getName();
		List<Flow> flows = flowService.findByName(name);
		if( flows.stream().anyMatch(f -> !f.getRowId().equals(this.flow.getRowId()))) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_FLOW_NAME_ALREADY_EXISTS).replace("{}",
					this.flow.getName());
			this.addErrorMessage(message);
			return false;
		}
		

		return true;
	}

	private boolean validadeGroupAction() {
		if (this.groupActionSelected == null) {
			this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_GROUP_ACTION_NOT_SELECTED));
			return false;
		}

		if (flow.getGroupActions().stream().anyMatch(groupAction -> !groupAction.equals(this.groupActionSelected)
				&& this.groupActionSelected.getName().equalsIgnoreCase(groupAction.getName()))) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_GROUP_ACTION_NAME_ALREADY_EXISTS).replace("{}",
					groupActionSelected.getName());
			this.addErrorMessage(message);
			return false;
		}
		if (!isValidURL(this.groupActionSelected.getUrl())) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_GROUP_ACTION_URL_MALFORMED).replace("{}",
					groupActionSelected.getUrl());
			this.addErrorMessage(message);
			return false;
		}

		return true;
	}

	private boolean isValidURL(String urlStr) {
		try {
			@SuppressWarnings("unused")
			URL url = new URL(urlStr);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}

	public void changeDecisionActionDoOption() {
		if (FormFieldDoOption.GOTO_NEXT.equals(decisionSelected.getDoOption())) {

		}
	}

	public List<GroupAction> getGroupActions() {
		return this.flow.getGroupActions();
	}

	private boolean validadeDecisionLoop(GroupAction groupAction, final Long nextGroupActionId,
			final List<GroupAction> groupActions) {
		if (groupAction != null && groupAction.getDecisions() != null) {
			for (DecisionAction decisionAction : groupAction.getDecisions()) {
				if (decisionAction.getNextGroup() != null) {
					if (nextGroupActionId.equals(decisionAction.getNextGroup())) {
						return true;
					} else {
						groupAction = groupActions.stream()
								.filter(ga -> ga.getRowId().equals(decisionAction.getNextGroup())).findFirst()
								.orElse(null);
						return validadeDecisionLoop(groupAction, nextGroupActionId, groupActions);
					}
				}
			}
		}
		return false;
	}

	private GroupAction getGroupActionFromFlowById(Long rowId) {
		return flow.getGroupActions().stream().filter(ga -> ga.getRowId().equals(rowId)).findFirst().orElse(null);
	}

	private boolean validateDecision() {

		if (this.decisionSelected == null) {
			this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_DECISION_NOT_SELECTED));
			return false;
		}

		if (FormFieldDoOption.SEND_EMAIL.equals(this.decisionSelected.getDoOption())
				|| FormFieldDoOption.WRITE_LOG.equals(this.decisionSelected.getDoOption())) {
			String message = this.getMessage(Constants.MESSAGE_WARNING_FUNCTION_NOT_AVAILABLE).replace("{}",
					this.getMessage(this.decisionSelected.getDoOption().getLabel()));
			this.addWarningMessage(message);
			return false;
		}

		if (FormFieldDoOption.GOTO_NEXT.equals(this.decisionSelected.getDoOption())
				&& !this.nextGroupIdSelected.equals(0)) {
			GroupAction groupAction = getGroupActionFromFlowById(this.nextGroupIdSelected);

			if (validadeDecisionLoop(groupAction, this.nextGroupIdSelected, flow.getGroupActions())) {
				String message = this.getMessage(Constants.MESSAGE_ERROR_DECISION_NEXT_GROUP_ACTION_LOOP).replace("{}",
						this.getMessage(this.decisionSelected.getDoOption().getLabel()));
				this.addWarningMessage(message);
				return false;
			}
		}

		if (this.groupActionSelected.getDecisions().stream().anyMatch(decision -> !decision.equals(decisionSelected)
				&& decisionSelected.getName().equalsIgnoreCase(decision.getName()))) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_DECISION_NAME_ALREADY_EXISTS).replace("{}",
					decisionSelected.getName());
			this.addErrorMessage(message);
			return false;
		}

		if (this.groupActionSelected.getDecisions().stream().anyMatch(decision -> !decision.equals(decisionSelected)
				&& decisionSelected.getSequence().equals(decision.getSequence()))) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_DECISION_SEQUENCE_ALREADY_EXISTS).replace("{}",
					decisionSelected.getSequence().toString());
			this.addErrorMessage(message);
			return false;
		}

		if (decisionSelected.getLogicalOperations() != null && decisionSelected.getLogicalOperations().size() > 0) {

			for (LogicalOperation lo : decisionSelected.getLogicalOperations()) {
				if (lo.getLogicalOperator() == null) {
					this.addErrorMessage(
							this.getMessage(Constants.MESSAGE_ERROR_DECISION_LOGICAL_OPERATOR_NOT_SELECTED));
					return false;
				} else {
					if (lo.getOperations() == null || lo.getOperations().size() == 0) {
						this.addErrorMessage(
								this.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_REGISTER));
						return false;
					} else {
						boolean erro = false;
						for (RelationalOperation ro : lo.getOperations()) {
							if (ro.getAction() == null || ro.getAction().getRowId().equals(0L)) {
								erro = true;
								this.addErrorMessage(this
										.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_ACTION));
							}
							if (ro.getOperator() == null) {
								erro = true;
								this.addErrorMessage(this
										.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_OPERATOR));
							}
							if (ro.getValue() == null || ro.getValue().length() == 0) {
								erro = true;
								this.addErrorMessage(
										this.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_VALUE));
							}
							if (erro) {
								return false;
							}
						}

					}
				}

			}
		}
		return true;
	}

	private boolean validateActionFields() {
		if (actionSelected.getWaitPreAction()) {

		}
		return true;
	}

	private boolean validateNewFrequenceDateTime() {
		if (flow.getFrequenceDateTime().stream()
				.anyMatch(dt -> dt.getDateTime().equals(this.frequenceDateTimeSelected.getDateTime()) 
						   		&& !dt.getRowId().equals(this.frequenceDateTimeSelected.getRowId()))) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_FREQUENCE_DATETIME_ALREADY_EXISTS);
			this.addErrorMessage(message);
			return false;
		}
		return true;
	}
	private boolean validadeNewFrequenceWeekDay() {
		if(flow.getFrequenceWeekDay().stream()
				.anyMatch(wd -> wd.getScheduledTime().equals(this.frequenceWeekDaySelected.getScheduledTime()) 
								&& wd.getWeekDay().equals(this.frequenceWeekDaySelected.getWeekDay()) 
								&& !wd.getRowId().equals(this.frequenceWeekDaySelected.getRowId()))) {
			String message = this.getMessage(Constants.MESSAGE_ERROR_FREQUENCE_WEEK_DAY_ALREADY_EXISTS);
			this.addErrorMessage(message);
			return false;
		}
		return true;
	}
	
	
	
	public void addFrequenceWeekDay() {
		if(validadeNewFrequenceWeekDay()) {
			this.flow.getFrequenceWeekDay().add(this.frequenceWeekDaySelected);
			this.frequenceWeekDaySelected.setNewObject(false);
			newFrequenceWeekDay();
		}
		
		
	}
	
	public void updateFrequenceWeekDay() {
		if(validadeNewFrequenceWeekDay()) {
			FrequenceWeekDay weekDay = this.flow.getFrequenceWeekDay().stream().filter(fwd -> fwd.getRowId().equals(this.frequenceWeekDaySelected.getRowId())).findFirst().get();
			
			weekDay.setWeekDay(this.frequenceWeekDaySelected.getWeekDay());
			weekDay.setScheduledTime(this.frequenceWeekDaySelected.getScheduledTime());
			
			newFrequenceWeekDay();
		}
		
	}
	public void newFrequenceWeekDay() {
		this.frequenceWeekDaySelected = new FrequenceWeekDay(this.frequenceWeekDayService.getNextRowId(), this.flow);
		
		
	}
	
	
	public void editFrequenceWeekDay(FrequenceWeekDay weekDay) {
		this.frequenceWeekDaySelected = new FrequenceWeekDay(weekDay.getRowId(), 
															 weekDay.getName(), 
															 weekDay.getFlow(),
															 weekDay.getWeekDay(),
															 weekDay.getScheduledTime(), 
															 weekDay.isActive(),
															 weekDay.isNewObject());	
		
	}

	public void onActionReorder(ReorderEvent event) {
		
		
		for(int index = 0; index < this.groupActionSelected.getActions().size(); index++) {
			Action action = this.groupActionSelected.getActions().get(index);
			if(action.getSequence() != index +1) {
				action.setSequence(index+1);
				this.actionService.updateSequence(action);
			}
			
			
		}
	}
	public void onDecisionReorder(ReorderEvent event) {
		
		
		for(int index = 0; index < this.groupActionSelected.getActions().size(); index++) {
			Action action = this.groupActionSelected.getActions().get(index);
			if(action.getSequence() != index +1) {
				action.setSequence(index+1);
				this.actionService.updateSequence(action);
			}
			
			
		}
	}
	
	public void removeFrequenceWeekDay() {
		this.flow.getFrequenceWeekDay().remove(frequenceWeekDayForRemove);
	}

	/**
	 * @return the actionSelectedForRemove
	 */
	public Action getActionSelectedForRemove() {
		return actionSelectedForRemove;
	}

	/**
	 * @param actionSelectedForRemove
	 *            the actionSelectedForRemove to set
	 */
	public void setActionSelectedForRemove(Action actionSelectedForRemove) {
		this.actionSelectedForRemove = actionSelectedForRemove;
	}

	public DecisionAction getDecisionSelectedForRemove() {
		return decisionSelectedForRemove;
	}

	public void setDecisionForRemove(DecisionAction decisionSelectedForRemove) {
		this.decisionSelectedForRemove = decisionSelectedForRemove;
	}

	public DecisionActionService getDecisionActionService() {
		return decisionActionService;
	}

	public void setDecisionActionService(DecisionActionService decisionActionService) {
		this.decisionActionService = decisionActionService;
	}

	public ActionService getActionService() {
		return actionService;
	}

	public void setActionService(ActionService actionService) {
		this.actionService = actionService;
	}

	public Long getNextGroupIdSelected() {
		return nextGroupIdSelected;
	}

	public void setNextGroupIdSelected(Long nextGroupIdSelected) {
		this.nextGroupIdSelected = nextGroupIdSelected;
	}

	public FrequenceDateTime getFrequenceDateTimeForRemove() {
		return frequenceDateTimeForRemove;
	}

	public void setFrequenceDateTimeForRemove(FrequenceDateTime frequenceDateTimeForRemove) {
		this.frequenceDateTimeForRemove = frequenceDateTimeForRemove;
	}

	public FrequenceDateTimeService getFrequenceDateTimeService() {
		return frequenceDateTimeService;
	}

	public void setFrequenceDateTimeService(FrequenceDateTimeService frequenceDateTimeService) {
		this.frequenceDateTimeService = frequenceDateTimeService;
	}

	public FrequenceWeekDayService getFrequenceWeekDayService() {
		return frequenceWeekDayService;
	}

	public void setFrequenceWeekDayService(FrequenceWeekDayService frequenceWeekDayService) {
		this.frequenceWeekDayService = frequenceWeekDayService;
	}

	public FrequenceIntervalService getFrequenceIntervalService() {
		return frequenceIntervalService;
	}

	public void setFrequenceIntervalService(FrequenceIntervalService frequenceIntervalService) {
		this.frequenceIntervalService = frequenceIntervalService;
	}

	public FrequenceWeekDay getFrequenceWeekDayForRemove() {
		return frequenceWeekDayForRemove;
	}
	
	

}
