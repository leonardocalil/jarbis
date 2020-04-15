package br.com.increaseit.internal.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.increaseit.common.constants.FormFieldRelationalOperator;


@Entity(name=RelationalOperation.TABLE_NAME)
@SequenceGenerator(name=RelationalOperation.SEQUENCE_GENERIC_NAME,sequenceName=RelationalOperation.SEQUENCE_NAME)
public class RelationalOperation extends AEntity<RelationalOperation> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2342058474625330465L;
	
	public static final String SEQUENCE_NAME = "SEQ_RELATIONAL_OPERATION";
	public static final String TABLE_NAME = "RELATIONAL_OPERATION";
	
	public RelationalOperation() {
		
	}
	
	public RelationalOperation(LogicalOperation logicalOperation) {	
		this.logicalOperation = logicalOperation;
	}
	
	
	
	public RelationalOperation(Long rowId, String name,
								Long actionId, FormFieldRelationalOperator operator, String value,
								Long logicalOperationId) {
		this.setRowId(rowId);
		this.name = name;
		this.operator = operator;
		this.value = value;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTION_ID")
	private Action action;
	
	@Column(name="OPERATOR")
	@Enumerated(EnumType.STRING)
	private FormFieldRelationalOperator operator;
	
	@Column(name="VALUE")
	private String value;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOGICAL_OPERATION_ID")
	private LogicalOperation logicalOperation;
	
	
	public FormFieldRelationalOperator getOperator() {
		return operator;
	}
	public void setOperator(FormFieldRelationalOperator operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}



	public Action getAction() {
		return action;
	}



	public void setAction(Action action) {
		this.action = action;
	}



	public LogicalOperation getLogicalOperation() {
		return logicalOperation;
	}



	public void setLogicalOperation(LogicalOperation logicalOperation) {
		this.logicalOperation = logicalOperation;
	}



	@Override
	public String toString() {
		return "RelationalOperation [operator=" + operator + ", value=" + value
				+ ", rowId=" + this.getRowId() + ", name=" + name + ", newObject="
				+ newObject + ", getOperator()=" + getOperator() + ", getValue()=" + getValue() + ", getRowId()="
				+ getRowId() + ", getName()=" + getName() + ", isNewObject()=" + isNewObject() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


}
