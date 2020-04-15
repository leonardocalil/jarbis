package br.com.increaseit.internal.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;



@Entity(name=Parameter.TABLE_NAME)
@SequenceGenerator(name=Parameter.SEQUENCE_GENERIC_NAME,sequenceName=Parameter.SEQUENCE_NAME)
public class Parameter extends AEntity<Parameter> {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4182156900633032647L;

	public static final String SEQUENCE_NAME = "SEQ_PARAMETER";
	public static final String TABLE_NAME = "PARAMETER";
	
	
	public Parameter() {
		
	}
	
	public Parameter(Action action) {
		this.action = action;
		
	}
	
	
	public Parameter(Long rowId, String name, Long groupId, Long actionId, String text) {
		this.setRowId(rowId);
		this.name = name;
		this.text = text;
	}
		
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST )
	@JoinColumn(name="ACTION_ID")
	private Action action;
	
	@Column(name="GROUP_ID")
	private Long groupId;
	
	@Column(name="TEXT")
	private String text;
	

	
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the value
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param value the value to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Parameter [groupId=" + groupId + ", text=" + text + ", getGroupId()="
				+ getGroupId() + ", getText()=" + getText() + ", getRowId()=" + getRowId() + ", getName()=" + getName()
				+ ", isNewObject()=" + isNewObject() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
