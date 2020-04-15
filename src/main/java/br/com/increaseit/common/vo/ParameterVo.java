package br.com.increaseit.common.vo;

public class ParameterVo extends ModelVo<ParameterVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8768947596537465969L;

	public static final String PARAMETER_CONSTANT = "CONSTANT";
	public static final String PARAMETER_VARIABLE_GROUP = "VARIABLE_GROUP";
	public static final String PARAMETER_VARIABLE_ACTION = "VARIABLE_ACTION";
	public static final String PARAMETER_VARIABLE_TABLE_COLUMN = "VARIABLE_TABLE_COLUMN";
	
	private Long groupActionId;
	private Long actionId;
	private String text;
	
	
	public ParameterVo(Long rowId, String name, Long groupActionId,  Long actionId, String text) {
		this.rowId = rowId;
		this.name = name;
		this.groupActionId = groupActionId;
		this.actionId = actionId;
		this.text = text;
	}
	
	public ParameterVo(Long groupActionId,  Long actionId) {
		this.groupActionId = groupActionId;
		this.actionId = actionId;
	
	}
	


	@Override
	protected Class<ParameterVo> getInstance() {
		return ParameterVo.class;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getGroupActionId() {
		return groupActionId;
	}

	public void setGroupActionId(Long groupActionId) {
		this.groupActionId = groupActionId;
	}

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
	
	
	
	
	
}
