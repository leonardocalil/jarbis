package br.com.increaseit.internal.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import br.com.increaseit.common.constants.FormFieldAction;
import br.com.increaseit.common.constants.FormFieldType;
import br.com.increaseit.common.constants.FormFieldTypeWrite;

@Entity(name=Action.TABLE_NAME)
@SequenceGenerator(name=Action.SEQUENCE_NAME,sequenceName=Action.SEQUENCE_GENERIC_NAME)
@DynamicUpdate
public class Action extends Field<Action> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5033262911027596911L;
	
	public static final String SEQUENCE_NAME = "SEQ_ACTION";

	public static final String TABLE_NAME = "ACTION";
	
	public Action() {
		preAction = null;
		posAction = null;
	}
	
	public Action(GroupAction groupAction) {
		this.groupAction = groupAction;
		this.preAction = null;
		this.posAction = null;
	}
	
	public Action(Long rowId, String name, Long groupActionId, FormFieldType fieldType, String fieldName,
			FormFieldAction doAction, FormFieldTypeWrite typeWrite, Parameter parameter, Wait preAction,
			Wait posAction, boolean waitPreAction, boolean waitPosAction) {
		this.setRowId(rowId);
		this.name = name;
		this.fieldType = fieldType;
		this.fieldName = fieldName;
		this.doAction = doAction;
		this.typeWrite = typeWrite;
		this.parameter = parameter;
		this.preAction = preAction;
		this.posAction = posAction;
		this.waitPreAction = waitPreAction;
		this.waitPosAction = waitPosAction;
	}
	
	@ManyToOne(fetch=FetchType.LAZY , cascade=CascadeType.PERSIST)
	@JoinColumn(name="GROUP_ACTION_ID")
	private GroupAction groupAction;
	
	
	
	@Column(name="DO_ACTION")
	@Enumerated(EnumType.STRING)
	private FormFieldAction doAction;
	
	@Column(name="TYPE_WRITE")
	@Enumerated(EnumType.STRING) 
	private FormFieldTypeWrite typeWrite;
	
	@OneToOne(mappedBy="action", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Parameter parameter;
	
	@OneToOne(mappedBy="preAction", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Wait preAction;
	
//	@OneToOne(mappedBy="posAction")
	@Transient
	private Wait posAction;
	
	@Column(name="WAIT_PRE_ACTION")
	private boolean waitPreAction;
	
	@Column(name="WAIT_POS_ACTION")
	private boolean waitPosAction;
	
	@Column(name="SEQUENCE")
	private Integer sequence;
	
	
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public FormFieldAction getDoAction() {
		return doAction;
	}
	public void setDoAction(FormFieldAction doAction) {
		this.doAction = doAction;
	}
	public Wait getPreAction() {
		return preAction;
	}
	public void setPreAction(Wait preAction) {
		this.preAction = preAction;
	}
	public Wait getPosAction() {
		return posAction;
	}
	public void setPosAction(Wait posAction) {
		this.posAction = posAction;
	}

	public boolean getWaitPreAction() {
		return waitPreAction;
	}

	public void setWaitPreAction(boolean waitPreAction) {
		this.waitPreAction = waitPreAction;
	}

	public boolean getWaitPosAction() {
		return waitPosAction;
	}

	public void setWaitPosAction(boolean waitPosAction) {
		this.waitPosAction = waitPosAction;	
	}

	/**
	 * @return the typeWrite
	 */
	public FormFieldTypeWrite getTypeWrite() {
		return typeWrite;
	}

	/**
	 * @param typeWrite the typeWrite to set
	 */
	public void setTypeWrite(FormFieldTypeWrite typeWrite) {
		this.typeWrite = typeWrite;
	}

	/**
	 * @return the parameters
	 */
	public Parameter getParameter() {
		if(parameter ==  null) {
			parameter = new Parameter(this);
		}
		return parameter;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Parameter parameter) {
		this.parameter = parameter;
	}
	
	
	

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doAction == null) ? 0 : doAction.hashCode());
		result = prime * result + ((parameter == null) ? 0 : parameter.hashCode());
		result = prime * result + ((posAction == null) ? 0 : posAction.hashCode());
		result = prime * result + ((preAction == null) ? 0 : preAction.hashCode());
		result = prime * result + ((typeWrite == null) ? 0 : typeWrite.hashCode());
		result = prime * result + (waitPosAction ? 1231 : 1237);
		result = prime * result + (waitPreAction ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Action)) {
			return false;
		}
		Action other = (Action) obj;
		if (doAction != other.doAction) {
			return false;
		}
		if (parameter == null) {
			if (other.parameter != null) {
				return false;
			}
		} else if (!parameter.equals(other.parameter)) {
			return false;
		}
		if (posAction == null) {
			if (other.posAction != null) {
				return false;
			}
		} else if (!posAction.equals(other.posAction)) {
			return false;
		}
		if (preAction == null) {
			if (other.preAction != null) {
				return false;
			}
		} else if (!preAction.equals(other.preAction)) {
			return false;
		}
		if (typeWrite != other.typeWrite) {
			return false;
		}
		if (waitPosAction != other.waitPosAction) {
			return false;
		}
		if (waitPreAction != other.waitPreAction) {
			return false;
		}
		return true;
	}

	public GroupAction getGroupAction() {
		return groupAction;
	}

	public void setGroupAction(GroupAction groupAction) {
		this.groupAction = groupAction;
	}

	@Override
	public String toString() {
		return "Action [doAction=" + doAction + ", typeWrite=" + typeWrite
				+ ", parameter=" + parameter + ", preAction=" + preAction + ", posAction=" + posAction
				+ ", waitPreAction=" + waitPreAction + ", waitPosAction=" + waitPosAction + ", getDoAction()="
				+ getDoAction() + ", getPreAction()=" + getPreAction() + ", getPosAction()=" + getPosAction()
				+ ", getWaitPreAction()=" + getWaitPreAction() + ", getWaitPosAction()=" + getWaitPosAction()
				+ ", getTypeWrite()=" + getTypeWrite() + ", getParameter()=" + getParameter() + ", hashCode()="
				+ hashCode() + ", getFieldType()=" + getFieldType()
				+ ", getFieldName()=" + getFieldName() + ", getRowId()=" + getRowId() + ", getName()=" + getName()
				+ ", isNewObject()=" + isNewObject() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
