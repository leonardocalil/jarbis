package br.com.increaseit.common.constants;

public enum FlowStatus {
	EDITING("flow.status.editing"),
	EXECUTING("flow.status.executing"),
	READY("flow.status.ready");
	
	
	private final String description;
	FlowStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
