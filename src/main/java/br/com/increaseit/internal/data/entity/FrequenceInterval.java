package br.com.increaseit.internal.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;


@Entity(name=FrequenceInterval.TABLE_NAME)
@SequenceGenerator(name=FrequenceInterval.SEQUENCE_GENERIC_NAME,sequenceName=FrequenceInterval.SEQUENCE_NAME)
public class FrequenceInterval extends Schedule{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7285519915454551936L;
	public static final String SEQUENCE_NAME = "SEQ_FREQUENCE_INTERVAL";
	public static final String TABLE_NAME = "FREQUENCE_INTERVAL"; 
	
	
	public FrequenceInterval() {
		
	}
	
	public FrequenceInterval(Long rowId, Flow flow) {
		this.setRowId(rowId);
		this.flow = flow;
	}

	@Column(name="INTERVAL")
	private Integer interval;
	
	@Column(name="LAST_EXECUTION")
	private Date lastExecution;

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public Date getLastExecution() {
		return lastExecution;
	}

	public void setLastExecution(Date lastExecution) {
		this.lastExecution = lastExecution;
	}
	
	
}
