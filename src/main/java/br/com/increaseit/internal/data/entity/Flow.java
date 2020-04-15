package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.com.increaseit.common.constants.FlowFrequence;
import br.com.increaseit.common.constants.FlowStatus;

@Entity(name=Flow.TABLE_NAME)
@SequenceGenerator(name=Flow.SEQUENCE_GENERIC_NAME,sequenceName=Flow.SEQUENCE_NAME)
public class Flow extends AEntity<Flow> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 251424678651379712L;
	
	public static final String SEQUENCE_NAME = "SEQ_FLOW";
	
	public static final String TABLE_NAME = "FLOW";

	public Flow() {
		this.frequenceInterval = null;
		this.frequenceWeekDay = new ArrayList<FrequenceWeekDay>();
		this.frequenceDateTime = new ArrayList<FrequenceDateTime>();		
		this.groupActions = new ArrayList<GroupAction>();
	}
	

	public Flow(Long rowId, String name, FlowFrequence frequence, 
				FrequenceInterval frequenceInterval, List<FrequenceWeekDay> frequenceWeekDay,
				List<FrequenceDateTime> frequenceDateTime, 
				List<GroupAction> groupActions) {
		this.setRowId(rowId);
		this.name = name;
		this.frequence = frequence;
		this.frequenceInterval = frequenceInterval;
		this.frequenceWeekDay = frequenceWeekDay;
		this.frequenceDateTime = frequenceDateTime;
		this.groupActions = groupActions;
	}
	
	@Column(name="NAME")	
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="FREQUENCE")
	private FlowFrequence frequence;
	
	@OneToOne(mappedBy="flow", cascade=CascadeType.ALL)
	private FrequenceInterval frequenceInterval;
	
	@OneToMany(mappedBy="flow", cascade=CascadeType.ALL)
	private List<FrequenceWeekDay> frequenceWeekDay;
	@OneToMany(mappedBy="flow", cascade=CascadeType.ALL)
	private List<FrequenceDateTime> frequenceDateTime;
	
	@OneToMany(mappedBy="flow", cascade=CascadeType.REMOVE)
	private List<GroupAction> groupActions;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private FlowStatus status;
	
	
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

	

	public FrequenceInterval getFrequenceInterval() {
		return frequenceInterval;
	}


	public void setFrequenceInterval(FrequenceInterval frequenceInterval) {
		this.frequenceInterval = frequenceInterval;
	}


	public List<FrequenceWeekDay> getFrequenceWeekDay() {
		Collections.sort(this.frequenceWeekDay);
		return frequenceWeekDay;
	}


	public void setFrequenceWeekDay(List<FrequenceWeekDay> frequenceWeekDay) {
		this.frequenceWeekDay = frequenceWeekDay;
	}


	public List<FrequenceDateTime> getFrequenceDateTime() {
		Collections.sort(this.frequenceDateTime);
		return frequenceDateTime;
	}


	public void setFrequenceDateTime(List<FrequenceDateTime> frequenceDateTime) {
		this.frequenceDateTime = frequenceDateTime;
	}


	public List<GroupAction> getGroupActions() {
		return groupActions;
	}

	public void setGroupActions(List<GroupAction> groupActions) {
		this.groupActions = groupActions;
	}
	

	public FlowStatus getStatus() {
		return status;
	}


	public void setStatus(FlowStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Flow [name=" + name + ", frequence=" + frequence + ", frequenceInterval=" + frequenceInterval + ", frequenceWeekDay=" + frequenceWeekDay
				+ ", frequenceDateTime=" + frequenceDateTime + ", groupActions=" + groupActions + ", getName()=" + getName()
				+ ", getFrequence()=" + getFrequence() + ", getRowId()=" + getRowId() + ", isNewObject()=" + isNewObject()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
