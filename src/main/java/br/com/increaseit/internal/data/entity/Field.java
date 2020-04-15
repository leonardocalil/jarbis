package br.com.increaseit.internal.data.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import br.com.increaseit.common.constants.FormFieldType;

@MappedSuperclass
@Inheritance
public abstract class Field<T> extends AEntity<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4541248767673424977L;

	
	public Field() {
		
	}
	
	
	public Field(Long rowId, String name, FormFieldType fieldType, String fieldName) {
		this.setRowId(rowId);
		this.name = name;
		this.fieldType = fieldType;
		this.fieldName = fieldName;
	}

	@Column(name = "FIELD_TYPE")
	@Enumerated(EnumType.STRING)
	protected FormFieldType fieldType;

	@Column(name = "FIELD_NAME")
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

}
