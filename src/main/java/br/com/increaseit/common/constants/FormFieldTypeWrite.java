package br.com.increaseit.common.constants;

public enum FormFieldTypeWrite {
	CONSTANT("form.field.type.write.constant"), 
	VARIABLE("form.field.type.write.variable");
	
	private final String label;
	
	FormFieldTypeWrite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
