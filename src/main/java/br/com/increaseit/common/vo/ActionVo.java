package br.com.increaseit.common.vo;

import br.com.increaseit.common.constants.FormFieldAction;
import br.com.increaseit.common.constants.FormFieldTypeWrite;

public class ActionVo extends FieldVo {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1983767672865518966L;
	
	public ActionVo(Long groupActionId) {
		this.groupActionId = groupActionId;
		preAction = null;
		posAction = null;
	}
	
	public ActionVo(Long rowId, String name, Long groupActionId,FormFieldAction doAction, FormFieldTypeWrite typeWrite, 
			ParameterVo parameter, WaitVo preAction, WaitVo posAction, 
			boolean waitPreAction, boolean waitPosAction) {
		this.rowId = rowId;
		this.name = name;
		this.groupActionId = groupActionId; 
		this.doAction = doAction;
		this.typeWrite = typeWrite;
		this.parameter = parameter;
		this.preAction = preAction;
		this.posAction = posAction;
		this.waitPreAction = waitPreAction;
		this.waitPosAction = waitPosAction;
	}

	private Long groupActionId;

	private FormFieldAction doAction;
	private FormFieldTypeWrite typeWrite;
	
	
	private ParameterVo parameter;
	
	private WaitVo preAction;
	private WaitVo posAction;
	
	private boolean waitPreAction;
	private boolean waitPosAction;
	
	
	public Long getGroupActionId() {
		return groupActionId;
	}

	public void setGroupActionId(Long groupActionId) {
		this.groupActionId = groupActionId;
	}

	public FormFieldAction getDoAction() {
		return doAction;
	}
	public void setDoAction(FormFieldAction doAction) {
		this.doAction = doAction;
	}
	public WaitVo getPreAction() {
		return preAction;
	}
	public void setPreAction(WaitVo preAction) {
		this.preAction = preAction;
	}
	public WaitVo getPosAction() {
		return posAction;
	}
	public void setPosAction(WaitVo posAction) {
		this.posAction = posAction;
		if (this.waitPreAction) {
			posAction = new WaitVo();
		} else {
			posAction = null;
		}
	}

	public boolean getWaitPreAction() {
		if (preAction != null) {
			waitPreAction = true;
		} else {
			waitPreAction = false;
		}
		return waitPreAction;
	}

	public void setWaitPreAction(boolean waitPreAction) {
		this.waitPreAction = waitPreAction;
		if (this.waitPreAction) {
			preAction = new WaitVo();
		} else {
			preAction = null;
		}
	}

	public boolean getWaitPosAction() {
		if (posAction != null) {
			waitPosAction = true;			
		} else {
			waitPosAction = false;
		}
		return waitPosAction;
	}

	public void setWaitPosAction(boolean waitPosAction) {
		this.waitPosAction = waitPosAction;
		if (this.waitPosAction) {
			posAction = new WaitVo();
		} else {
			posAction = null;
		}
		
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
	public ParameterVo getParameter() {
		return parameter;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameter(ParameterVo parameter) {
		this.parameter = parameter;
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
		if (!(obj instanceof ActionVo)) {
			return false;
		}
		ActionVo other = (ActionVo) obj;
		if (doAction != other.doAction) {
			return false;
		}
		if (parameter == null) {
			if (other.parameter != null) {
				return false;
			}
		} else if (parameter.equals(other.parameter)) {
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
	
	
	
	
	
	
}
