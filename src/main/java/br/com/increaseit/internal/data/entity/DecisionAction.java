package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.increaseit.common.constants.FormFieldDoOption;


@Entity(name=DecisionAction.TABLE_NAME)
@SequenceGenerator(name=DecisionAction.SEQUENCE_GENERIC_NAME,sequenceName=DecisionAction.SEQUENCE_NAME)
public class DecisionAction extends AEntity<DecisionAction> {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5032707879090065360L;
	
	public static final String SEQUENCE_NAME = "SEQ_DECISION_ACTION";
	
	public static final String TABLE_NAME = "DECISION_ACTION";
	
	
	public DecisionAction() {
		
	}
	
	public DecisionAction(GroupAction groupAction) {
		this.groupAction = groupAction;
	}
	
	
	public DecisionAction(Long rowId, String name, 
							Integer sequence, 
							List<LogicalOperation> logicalOperations, 
							FormFieldDoOption doOption,
							Long groupActionId, Long nextGroupId) {
		this.setRowId(rowId);
		this.name = name;
		this.sequence = sequence;
		this.logicalOperations = logicalOperations;
		this.doOption = doOption;
	}


	@Column(name="SEQUENCE")
	private Integer sequence;
	
	@OneToMany(mappedBy="decisionAction")
	private List<LogicalOperation> logicalOperations;
	
	@Column(name="DO_OPTION")
	@Enumerated(EnumType.STRING)
	private FormFieldDoOption doOption;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GROUP_ACTION_ID")
	private GroupAction groupAction;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name="NEXT_GROUP_ID")
	private GroupAction nextGroup;
	
	




	public FormFieldDoOption getDoOption() {
		return doOption;
	}

	public void setDoOption(FormFieldDoOption doOption) {
		this.doOption = doOption;
		
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public List<LogicalOperation> getLogicalOperations() {
		if (logicalOperations == null) {
			logicalOperations = new ArrayList<LogicalOperation>();
		}
		return logicalOperations;
	}

	public void setLogicalOperations(List<LogicalOperation> logicalOperations) {
		this.logicalOperations = logicalOperations;
	}

	public GroupAction getGroupAction() {
		return groupAction;
	}

	public void setGroupAction(GroupAction groupAction) {
		this.groupAction = groupAction;
	}

	public GroupAction getNextGroup() {
		return nextGroup;
	}

	public void setNextGroup(GroupAction nextGroup) {
		this.nextGroup = nextGroup;
	}

	@Override
	public String toString() {
		return "DecisionAction [sequence=" + sequence + ", logicalOperations=" + logicalOperations + ", doOption="
				+ doOption + ", rowId=" + this.getRowId()
				+ ", name=" + name + ", newObject=" + newObject + ", getDoOption()=" + getDoOption()
				+ ", getSequence()=" + getSequence() + ", getLogicalOperations()=" + getLogicalOperations()
				+ ", getRowId()=" + getRowId() + ", getName()=" + getName() + ", isNewObject()=" + isNewObject()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

		
}
