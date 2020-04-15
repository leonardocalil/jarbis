package br.com.increaseit.common.constants;

public enum FormFieldAction {
	CLICK("form.field.action.click"), 
	READ_FIELD("form.field.action.read.field"),
	READ_TABLE("form.field.action.read.table"),
	WRITE("form.field.action.write"); 
	
	private final String label;

	FormFieldAction(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
