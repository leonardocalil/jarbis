package br.com.increaseit.common.constants;

public enum FormFieldRelationalOperator {
	EQUAL("=="),
	NOR_EQUAL("!="),
	GREATER(">"),
	LESS("<"),
	GREATER_EQUAL(">="),
	LESS_EQUAL("<=");
	
	private final String label;
	
	FormFieldRelationalOperator(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
	
	
	
	
}
