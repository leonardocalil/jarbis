package br.com.increaseit.common.vo;

import br.com.increaseit.common.constants.FormFieldType;

public class WaitVo extends FieldVo {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1875555261908645286L;
	
	public WaitVo() {
		
	}
	
	
	public WaitVo(Long rowId, String name,
				  FormFieldType fieldType, 
				  String fieldName,	
				  Integer timeOut,
				  Long actionId) {
		this.rowId = rowId;
		this.name = name;
		this.fieldType = fieldType;
		this.fieldName = fieldName;
		this.timeOut = timeOut;
		this.actionId = actionId;
	}
	private Integer timeOut;
	private Long actionId;
	
	public Integer getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}


	public Long getActionId() {
		return actionId;
	}


	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
	
	
	
}
