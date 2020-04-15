package br.com.increaseit.internal.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import br.com.increaseit.common.constants.FormFieldType;


@Entity(name=Wait.TABLE_NAME)
@SequenceGenerator(name=Wait.SEQUENCE_GENERIC_NAME,sequenceName=Wait.SEQUENCE_NAME)
public class Wait extends Field<Wait> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1875555261908645286L;
	
	public static final String SEQUENCE_NAME = "SEQ_WAIT";
	public static final String TABLE_NAME = "WAIT";
	
	public Wait() {
		
	}
	
	public Wait(Action preAction, Action posAction) {
		this.preAction = preAction;
		this.posAction = posAction;
	}
	
	public Wait(Long rowId, String name, 
			    FormFieldType fieldType, String fieldName, 
			    Integer timeOut) {
		
		this.setRowId(rowId);
		this.name = name;
		this.fieldType = fieldType;
		this.fieldName = fieldName;
		this.timeOut = timeOut;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTION_ID")
	private Action preAction;
	
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn(referencedColumnName="ACTION_ID")
	@Transient
	private Action posAction;
	
	@Column(name="TIMEOUT")
	private Integer timeOut;
	
	public Integer getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public Action getPreAction() {
		return preAction;
	}

	public void setPreAction(Action preAction) {
		this.preAction = preAction;
	}

	public Action getPosAction() {
		return posAction;
	}

	public void setPosAction(Action posAction) {
		this.posAction = posAction;
	}

	@Override
	public String toString() {
		return "Wait [timeOut=" + timeOut + ", fieldType="
				+ fieldType + ", fieldName=" + fieldName + ", rowId=" + this.getRowId() + ", name=" + name + ", newObject="
				+ newObject + ", getTimeOut()=" + getTimeOut() + ", getFieldType()=" + getFieldType()
				+ ", getFieldName()=" + getFieldName() + ", getRowId()=" + getRowId() + ", getName()=" + getName()
				+ ", isNewObject()=" + isNewObject() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
