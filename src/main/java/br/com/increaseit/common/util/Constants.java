package br.com.increaseit.common.util;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	private static Constants instance;
	
	private List<String> ignoreFields; 
	
	private Constants() {
		ignoreFields = new ArrayList<String>();
		ignoreFields.add("serialVersionUID");
	}
	public static Constants getInstance() {
		if (instance == null) {
			instance = new Constants();
		}
		return instance;
	}
	public List<String> getIgnoreFields() {
		return ignoreFields;
	}
	public void setIgnoreFields(List<String> ignoreFields) {
		this.ignoreFields = ignoreFields;
	}
	
	
	
	public static final String FORM_FLOW_ACTION_DIALOG = "dialogAction";
	public static final String FORM_FLOW_DECISION_DIALOG = "dialogDecision";
	
	public static final String MESSAGE_NAME_DECISION_GROUP_DEFAULT = "message.name.decision.group.default";
	
	public static final String MESSAGE_ERROR_FLOW_NAME_ALREADY_EXISTS = "message.error.flow.name.already.exists";
	
	public static final String MESSAGE_ERROR_FLOW_FREQUENCE_AT_LEAST_ONE_WEEKDAY = "message.error.flow.frequence.at.least.one.weekday";
	
	public static final String MESSAGE_ERROR_FLOW_FREQUENCE_AT_LEAST_ONE_DATETIME = "message.error.flow.frequence.at.least.one.datetime";
	
	
	public static final String MESSAGE_ERROR_STEP_ACTION_NOT_SELECTED = "message.error.step.action.not.selected";
	public static final String MESSAGE_ERROR_STEP_ACTION_NAME_ALREADY_EXISTS = "message.error.step.action.name.already.exists";
	
	public static final String MESSAGE_ERROR_GROUP_ACTION_NOT_SELECTED = "message.error.group.action.not.selected";
	public static final String MESSAGE_ERROR_GROUP_ACTION_NAME_ALREADY_EXISTS = "message.error.group.action.name.already.exists";
	public static final String MESSAGE_ERROR_GROUP_ACTION_URL_MALFORMED = "message.error.group.action.url.malformed";
	
	public static final String MESSAGE_ERROR_DECISION_NOT_SELECTED = "message.error.decision.not.selected";
	public static final String MESSAGE_ERROR_DECISION_SEQUENCE_ALREADY_EXISTS = "message.error.decision.sequece.already.exists";
	public static final String MESSAGE_ERROR_DECISION_NAME_ALREADY_EXISTS = "message.error.decision.name.already.exists";
	public static final String MESSAGE_ERROR_DECISION_LOGICAL_OPERATOR_NO_REGISTER = "message.error.decision.logical.operator.no.register";
	public static final String MESSAGE_ERROR_DECISION_LOGICAL_OPERATOR_NOT_SELECTED = "message.error.decision.logical.operator.not.selected";
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_REGISTER = "message.error.decision.relational.operator.no.register";
	
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_ACTION = "message.error.decision.relational.operator.no.action";
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_OPERATOR = "message.error.decision.relational.operator.no.operator";
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_VALUE = "message.error.decision.relational.operator.no.value";
	
	public static final String MESSAGE_ERROR_FREQUENCE_DATETIME_ALREADY_EXISTS = "message.error.frequence.datetime.already.exists";
	
	public static final String MESSAGE_ERROR_FREQUENCE_WEEK_DAY_ALREADY_EXISTS = "message.error.frequence.week.day.already.exists";
	
	public static final String MESSAGE_ERROR_DECISION_NEXT_GROUP_ACTION_LOOP = "message.error.decision.next.group.action.loop";
	
	public static final String MESSAGE_WARNING_FUNCTION_NOT_AVAILABLE = "message.warning.function.not.available";
	
	public static final String MESSAGE_WARNING_GROUP_ACTION_SHOULD_BE_SAVE = "message.warning.group.action.should.be.save";
	
	public static final String MESSAGE_CONTENT_SELECT = "content.select";
		
	public static final String MESSAGE_NAME_DECISIOUN_GROUP_DEFAULT = "message.name.decision.group.default";
	
	public static final String MESSAGE_INFO_REGISTER_SAVE ="message.info.register.save";
	
}
