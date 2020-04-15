package br.com.increaseit.common.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.constants.FormFieldDoOption;

public class DecisionActionVo extends ModelVo<DecisionActionVo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4055174234133965159L;
	
	public DecisionActionVo(Long groupActionId) {
		this.groupActionId = groupActionId;
		
	}
	
	
	public DecisionActionVo(Long rowId, String name, Integer sequence, List<LogicalOperationVo> logicalOperations, 
							FormFieldDoOption doOption, Long groupActionId, Long nextGroupId) {
		this.rowId =  rowId;
		this.name = name;
		this.sequence = sequence;
		this.logicalOperations = logicalOperations;
		this.doOption = doOption;
		this.groupActionId = groupActionId;
		this.nextGroupId = nextGroupId;
	}


	private Integer sequence;
	
	private List<LogicalOperationVo> logicalOperations;
	
	
	private FormFieldDoOption doOption;
	
	private Long nextGroupId;
	
	private Long groupActionId;


	@Override
	protected Class<DecisionActionVo> getInstance() {
		return DecisionActionVo.class;
	}
	
	
	public Long getNextGroupId() {
		return nextGroupId;
	}


	public void setNextGroupId(Long nextGroupId) {
		this.nextGroupId = nextGroupId;
	}


	public FormFieldDoOption getDoOption() {
		return doOption;
	}

	public void setDoOption(FormFieldDoOption doOption) {
		this.doOption = doOption;
		 
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public List<LogicalOperationVo> getLogicalOperations() {
		if (logicalOperations == null) {
			logicalOperations = new ArrayList<LogicalOperationVo>();
		}
		return logicalOperations;
	}

	public void setLogicalOperations(List<LogicalOperationVo> logicalOperations) {
		this.logicalOperations = logicalOperations;
	}
	
	
	public Long getGroupActionId() {
		return groupActionId;
	}


	public void setGroupActionId(Long groupActionId) {
		this.groupActionId = groupActionId;
	}
		
	
}
