package br.com.increaseit.common.vo;

import br.com.increaseit.common.constants.FormFieldType;

public class FieldVo extends ModelVo<FieldVo> {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6458458189838211556L;
	
	public FieldVo() {
		
	}
	
	
	
	public FieldVo(Long rowId, String name, FormFieldType fieldType, String fieldName) {
		this.rowId = rowId;
		this.name = name;
		this.fieldType = fieldType;
		this.fieldName = fieldName;
	}



	protected FormFieldType fieldType;
	protected String fieldName;
	public FormFieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(FormFieldType fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	@Override
	protected Class<FieldVo> getInstance() {
		return FieldVo.class;
	}
	
		
	
}
