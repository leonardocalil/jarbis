package br.com.increaseit.internal.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name=FlowLogResults.TABLE_NAME)
@SequenceGenerator(name=FlowLogResults.SEQUENCE_NAME,sequenceName=FlowLogResults.SEQUENCE_NAME)
public class FlowLogResults implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 251424679651379712L;
	
	public static final String SEQUENCE_NAME = "SEQ_FLOW_LOG_RESULTS";
	
	public static final String TABLE_NAME = "FLOW_LOG_RESULTS";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=FlowLogResults.SEQUENCE_NAME)
	@Column(name="ROW_ID")
	private Long rowId;
	
	@Column(name="PARAM_NAME")
	private String paramName;
	
	@Column(name="PARAM_VALUE")
	private String paramValue;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FLOW_LOG_ID")
	private FlowLog flowLog;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public FlowLog getFlowLog() {
		return flowLog;
	}

	public void setFlowLog(FlowLog flowLog) {
		this.flowLog = flowLog;
	}
	
	
	

	
}
