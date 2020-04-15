package br.com.increaseit.internal.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import br.com.increaseit.common.constants.LogStatus;

@Entity(name=FlowLog.TABLE_NAME)
public class FlowLog implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 251424679651379712L;
	
	public static final String SEQUENCE_NAME = "SEQ_FLOW_LOG";
	
	public static final String TABLE_NAME = "FLOW_LOG";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence")
	@SequenceGenerator(schema="public", initialValue=1, name="sequence", sequenceName="SEQ_FLOW_LOG")
	@Column(name="ROW_ID")
	private Long rowId;
	
	@Column(name="FLOW_ID")
	private Long flowId;
	
	@Column(name="GROUP_ACTION_ID")
	private Long groupActionId;
	
	@Column(name="STEP_ACTION_ID")
	private Long stepActionId;
	
	@Column(name="WAIT_ID")
	private Long waitId;
	
	@Column(name="DECISION_ID")
	private Long decisionId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STARTED_DATETIME")
	private Date startedDatetime;
	
	@Column(name="FINISHED_DATETIME")
	private Date finishedDatetime;
	
	
	@Column(name="RESULT_VALUE")
	private String resultValue;
	
	@Column(name="MULTIPLE_RESULT")
	private Boolean multipleResult;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private LogStatus status;
	
	@Column(name="ERROR_MESSAGE")
	private String errorMessage;
	
	
	@OneToMany(mappedBy="flowLog", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST )
	private List<FlowLogResults> multipleResultValues;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}

	public Long getGroupActionId() {
		return groupActionId;
	}

	public void setGroupActionId(Long groupActionId) {
		this.groupActionId = groupActionId;
	}

	public Long getStepActionId() {
		return stepActionId;
	}
	public void setStepActionId(Long stepActionId) {
		this.stepActionId = stepActionId;
	}

	public Long getDecisionId() {
		return decisionId;
	}

	public void setDecisionId(Long decisionId) {
		this.decisionId = decisionId;
	}

	public Date getStartedDatetime() {
		return startedDatetime;
	}

	public void setStartedDatetime(Date startedDatetime) {
		this.startedDatetime = startedDatetime;
	}

	public Date getFinishedDatetime() {
		return finishedDatetime;
	}

	public void setFinishedDatetime(Date finishedDatetime) {
		this.finishedDatetime = finishedDatetime;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public Boolean getMultipleResult() {
		return multipleResult;
	}

	public void setMultipleResult(Boolean multipleResult) {
		this.multipleResult = multipleResult;	
	}

	public List<FlowLogResults> getMultipleResultValues() {
		return multipleResultValues;
	}

	public void setMultipleResultValues(List<FlowLogResults> multipleResultValues) {
		this.multipleResultValues = multipleResultValues;
	}

	public Long getWaitId() {
		return waitId;
	}

	public void setWaitId(Long waitId) {
		this.waitId = waitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LogStatus getStatus() {
		return status;
	}

	public void setStatus(LogStatus status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	
	
	

	
}
