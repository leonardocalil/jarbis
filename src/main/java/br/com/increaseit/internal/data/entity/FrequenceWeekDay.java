package br.com.increaseit.internal.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;

import br.com.increaseit.common.constants.EnumWeekDay;
import br.com.increaseit.common.constants.FlowStatus;

@Entity(name=FrequenceWeekDay.TABLE_NAME)
@SequenceGenerator(name=FrequenceWeekDay.SEQUENCE_GENERIC_NAME,sequenceName=FrequenceInterval.SEQUENCE_NAME)
public class FrequenceWeekDay extends Schedule implements Comparable<FrequenceWeekDay>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1278156522936110562L;
	public static final String TABLE_NAME = "FREQUENCE_WEEKDAY";
	public static final String SEQUENCE_NAME = "SEQ_FREQUENCE_WEEKDAY";
	
	
	public FrequenceWeekDay() {}
	
	public FrequenceWeekDay(Long rowId, Flow flow) {
		this.setRowId(rowId);
		this.flow = flow;
	}
	
	public FrequenceWeekDay(Long rowId,
							String name,
							Flow flow,
							EnumWeekDay weekDay, 
							Date scheduledTime,
							boolean active,
							boolean newObject) {
		this.setRowId(rowId);
		this.name = name;
		this.flow = flow;
		this.weekDay = weekDay;
		this.scheduledTime = scheduledTime;
		this.active = active;
		this.newObject = newObject;
	}

	@Column(name="WEEK_DAY")
	private EnumWeekDay weekDay;
	
	@Column(name="SCHEDULED_TIME")
	private Date scheduledTime;
	
	public EnumWeekDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(EnumWeekDay weekDay) {
		this.weekDay = weekDay;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	@Override
	public int compareTo(FrequenceWeekDay o) {
		if (this.weekDay != null 
				&& this.scheduledTime != null
				&& o != null
				&& o.getWeekDay() != null
				&& o.getScheduledTime() != null) {
			if (this.weekDay == o.getWeekDay()) {
				if(this.scheduledTime.equals(o.getScheduledTime())) {
					return 0;
				} else if(this.scheduledTime.after(o.getScheduledTime())) {
					return 1;
				} else {
					return -1;  
				}
				
				
			} if (this.weekDay.getId() > o.getWeekDay().getId()) {
				return 1;
			} else {
				return -1;
			}
			
		}	
		return 0;
	}

	
	
	
	
	
}
