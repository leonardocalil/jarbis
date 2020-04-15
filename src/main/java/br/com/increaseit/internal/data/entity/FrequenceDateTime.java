package br.com.increaseit.internal.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;

import br.com.increaseit.common.constants.FlowStatus;


@Entity(name=FrequenceDateTime.TABLE_NAME)
@SequenceGenerator(name=FrequenceDateTime.SEQUENCE_GENERIC_NAME,sequenceName=FrequenceDateTime.SEQUENCE_NAME)
public class FrequenceDateTime extends Schedule implements Comparable<FrequenceDateTime> {

	
	/**
	 * 
	 */
	public static final String SEQUENCE_NAME = "SEQ_FREQUENCE_DATETIME";
	
	public static final String TABLE_NAME = "FREQUENCE_DATETIME";
	
	private static final long serialVersionUID = 6681111404847955166L;
	
	
	
	
	public FrequenceDateTime() {
	}

	public FrequenceDateTime(Long rowId, Flow flow)  {
		this.setRowId(rowId);
		this.flow = flow;
	}
	
	public FrequenceDateTime(Long rowId, 
							String name,
							Flow flow,
							Date dateTime, 
							boolean active, boolean newObject) {

		this.setRowId(rowId);
		this.name = name;
		this.flow = flow;
		this.dateTime = dateTime;
		this.active = active;
		this.newObject = newObject;
	}

	@Column(name="DATE_TIME")
	private Date dateTime;
	
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int compareTo(FrequenceDateTime o) {

		if (this.dateTime != null 
				&& o != null) {
			if (this.dateTime.equals(o.getDateTime())) {
				return 0;
			} else if (this.dateTime.after(o.getDateTime())) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
			
		
	}
	
	
	
}
