package br.com.increaseit.common.constants;

public enum FormFieldDoOption {
	NOTHING("form.field.do.option.nothing"),
	SEND_EMAIL("form.field.do.option.send.email"),
	WRITE_LOG("form.field.do.option.write.log"),
	GOTO_NEXT("form.field.do.option.goto.next");
	
	private final String label;
	
	FormFieldDoOption (String label) {
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	
	
	
	
	
}
