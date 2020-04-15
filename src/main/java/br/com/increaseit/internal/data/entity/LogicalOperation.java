package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.increaseit.common.constants.FormFieldLogicalOperator;

@Entity(name=LogicalOperation.TABLE_NAME)
@SequenceGenerator(name=LogicalOperation.SEQUENCE_GENERIC_NAME,sequenceName=LogicalOperation.SEQUENCE_NAME)
public class LogicalOperation extends AEntity<LogicalOperation> {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6564801100428915850L;
	
	public static final String SEQUENCE_NAME = "SEQ_LOGICAL_OPERATION";
	public static final String TABLE_NAME = "LOGICAL_OPERATION";
	
	
	public LogicalOperation() {
		
	}
	
	public LogicalOperation(DecisionAction decisionAction) {
		this.decisionAction = decisionAction;
	}
	
	public LogicalOperation(Long rowId, String name,
							Long decisionActionId,
							FormFieldLogicalOperator logicalOperator, List<RelationalOperation> operations) {
		this.setRowId(rowId);
		this.name = name;
		this.logicalOperator = logicalOperator;
		this.operations = operations;
	}
	@Column(name="LOGICAL_OPERATOR")
	@Enumerated(EnumType.STRING)
	private FormFieldLogicalOperator logicalOperator;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DECISION_ACTION_ID")
	private DecisionAction decisionAction;
	
	@OneToMany(mappedBy="logicalOperation")
	private List<RelationalOperation> operations;
	
	public FormFieldLogicalOperator getLogicalOperator() {
		return logicalOperator;
	}
	public void setLogicalOperator(FormFieldLogicalOperator logicalOperator) {
		this.logicalOperator = logicalOperator;
	}
	public List<RelationalOperation> getOperations() {
		if (this.operations == null) {
			this.operations = new ArrayList<RelationalOperation>(); 
		}
		return this.operations;
	}
	public void setOperations(List<RelationalOperation> operations) {
		this.operations = operations;
	}

	public DecisionAction getDecisionAction() {
		return decisionAction;
	}

	public void setDecisionAction(DecisionAction decisionAction) {
		this.decisionAction = decisionAction;
	}

	@Override
	public String toString() {
		return "LogicalOperation [logicalOperator=" + logicalOperator 
				+ ", operations=" + operations + ", rowId=" + this.getRowId() + ", name=" + name + ", newObject=" + newObject
				+ ", getLogicalOperator()=" + getLogicalOperator() + ", getOperations()=" + getOperations()
				+ ", getRowId()=" + getRowId() + ", getName()=" + getName() + ", isNewObject()=" + isNewObject()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
