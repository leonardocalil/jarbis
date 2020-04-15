package br.com.increaseit.common.constants;

public enum FlowFrequence {
	CYCLIC_MINUTE("flow.frequence.cyclic.minute"),
	CYCLIC_WEEKDAY("flow.frequence.cyclic.weekday"),
	SCHEDULED("flow.frequence.scheduled");
	
	private final String description;
	FlowFrequence(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
