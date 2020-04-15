package br.com.increaseit.common.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.constants.FlowFrequence;

public class FlowVo extends ModelVo<FlowVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7363335333719369077L;
	private String name;
	private FlowFrequence frequence;
	private IntervalVo interval;
	private List<WeekDayVo> weekDay;
	private List<DateScheduledVo> dateScheduled;
	private List<GroupActionVo> groupActions;
	
	public FlowVo() {
		this.interval = new IntervalVo();
		this.weekDay = new ArrayList<WeekDayVo>();
		this.dateScheduled = new ArrayList<DateScheduledVo>();		
		this.groupActions = new ArrayList<GroupActionVo>();
	}
	
	
	public FlowVo(Long rowId, String name, FlowFrequence frequence, 
				  IntervalVo interval, List<WeekDayVo> weekDay,
				  List<DateScheduledVo> dateScheduled, 
				  List<GroupActionVo> groupActions) {
		this.rowId = rowId;
		this.name = name;
		this.frequence = frequence;
		this.interval = interval;
		this.weekDay = weekDay;
		this.dateScheduled = dateScheduled;
		this.groupActions = groupActions;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FlowFrequence getFrequence() {
		return frequence;
	}
	public void setFrequence(FlowFrequence frequence) {
		this.frequence = frequence;
	}
	
	public IntervalVo getInterval() {
		return interval;
	}
	public void setInterval(IntervalVo interval) {
		this.interval = interval;
	}

	public List<WeekDayVo> getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(List<WeekDayVo> weekDay) {
		this.weekDay = weekDay;
	}
	public List<DateScheduledVo> getDateScheduled() {
		return dateScheduled;
	}
	public void setDateScheduled(List<DateScheduledVo> dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public List<GroupActionVo> getGroupActions() {
		if (groupActions == null) {
			groupActions = new ArrayList<GroupActionVo>();
		}
		return groupActions;
	}

	public void setGroupActions(List<GroupActionVo> groupActions) {
		this.groupActions = groupActions;
	}

	@Override
	protected Class<FlowVo> getInstance() {
		// TODO Auto-generated method stub
		return FlowVo.class;
	}

	
	
	
	
}
