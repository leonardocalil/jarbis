package br.com.increaseit.common.vo;

import java.util.Date;

public class DateScheduledVo extends ScheduleVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1163511612801267685L;
	
	
	
	public DateScheduledVo(Long rowId, String name, boolean active, Date dateTime) {
		this.rowId = rowId;
		this.name = name;
		this.active = active;
		this.dateTime = dateTime;
	}

	private Date dateTime;

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
