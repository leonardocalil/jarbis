package br.com.increaseit.common.constants;

public enum FormFieldLogicalOperator {
	AND("form.field.logic.operator.and.click"),
	OR("form.field.logic.operator.or.click");
	
	private final String label;
	
	FormFieldLogicalOperator(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
	
	
	
	
}
