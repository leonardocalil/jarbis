package br.com.increaseit.common.constants;

public enum ScheduleStatus {
	WAITING("schedule.status.waiting"),
	EXECUTING("schedule.status.executing"),
	FINISHED("schedule.status.finished"),
	EDITING("schedule.status.editing");
	
	private final String description;
	ScheduleStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
