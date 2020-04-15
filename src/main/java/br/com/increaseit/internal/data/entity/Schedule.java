package br.com.increaseit.internal.data.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import br.com.increaseit.common.constants.FlowStatus;
import br.com.increaseit.common.constants.ScheduleStatus;

@MappedSuperclass
@Inheritance
public class Schedule extends AEntity<Schedule> {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5593620897214795294L;
	public static final String SEQUENCE_NAME = "SEQ_VIRTUAL_ID";

	public static final String TABLE_NAME = "SCHEDULE";
	
	
	@Column(name="ACTIVE")
	protected boolean active;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FLOW_ID")
	protected Flow flow;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private ScheduleStatus status;
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public ScheduleStatus getStatus() {
		return status;
	}

	public void setStatus(ScheduleStatus status) {
		this.status = status;
	}
	
	
	

	
}
