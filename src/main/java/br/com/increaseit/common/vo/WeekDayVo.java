package br.com.increaseit.common.vo;

import br.com.increaseit.common.constants.EnumWeekDay;

public class WeekDayVo extends ScheduleVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6595241402279841618L;
	
	public WeekDayVo() {
		
	}
	
	public WeekDayVo(Long rowId, String name, boolean active, 
					 EnumWeekDay weekDay, String time) {
		this.rowId = rowId;
		this.name = name;
		this.active = active;
		this.weekDay = weekDay;
		this.time = time;
	}

	private EnumWeekDay weekDay;
	private String time;

	public EnumWeekDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(EnumWeekDay weekDay) {
		this.weekDay = weekDay;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
