package br.com.increaseit.common.vo;

import br.com.increaseit.common.constants.FormFieldRelationalOperator;

public class RelationalOperationVo extends ModelVo<RelationalOperationVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1306352046139544682L;

	public RelationalOperationVo(Long logicalOperationId) {
		
	}
	
	public RelationalOperationVo(Long rowId, String name,
								 Long actionId, 
								 FormFieldRelationalOperator operator, 
								 String value, 
								 Long logicalOperationId) {
		this.rowId = rowId;
		this.name = name;
		this.actionId = actionId;
		this.operator = operator;
		this.value = value;
		this.logicalOperationId = logicalOperationId;
	}



	private Long actionId;
	private FormFieldRelationalOperator operator;
	private String value;
	private Long logicalOperationId;
	
	
	
	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

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
	
	public Long getLogicalOperationId() {
		return logicalOperationId;
	}

	public void setLogicalOperationId(Long logicalOperationId) {
		this.logicalOperationId = logicalOperationId;
	}

	@Override
	protected Class<RelationalOperationVo> getInstance() {
		// TODO Auto-generated method stub
		return RelationalOperationVo.class;
	}
	
	
	
		
}
