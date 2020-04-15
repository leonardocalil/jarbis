package br.com.increaseit.common.vo;

public class IntervalVo extends ScheduleVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6580069649945939167L;
	
	public IntervalVo() {
		
	}
	
	public IntervalVo(Long rowId, String name, boolean active, Double interval) {
		this.rowId = rowId;
		this.name = name;
		this.active = active;
		this.interval = interval;
	}

	private Double interval;

	public Double getInterval() {
		return interval;
	}

	public void setInterval(Double interval) {
		this.interval = interval;
	}
	
	
}
