package br.com.increaseit.common.constants;

public enum EnumWeekDay {
	MONDAY(1, "weekday.mon.label"),
	TUESDAY(2, "weekday.tue.label"),
	WEDNESDAY(3, "weekday.wed.label"),
	THURSDAY(4, "weekday.thu.label"),
	FRIDAY(5, "weekday.fri.label"),
	SATURDAY(6, "weekday.sat.label"),
	SUNDAY(7, "weekday.sun.label");
	
	private final Integer id;
	private final String label;
	
	EnumWeekDay(Integer id, String label) {
		this.id = id;
		this.label = label;
	}
	public Integer getId() {
		return id;
	}
	public String getLabel() {
		return label;
	}
	
}
