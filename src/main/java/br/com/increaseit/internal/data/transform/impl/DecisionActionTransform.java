package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.DecisionActionVo;
import br.com.increaseit.internal.data.entity.DecisionAction;
import br.com.increaseit.internal.data.transform.Transform;

public class DecisionActionTransform 
	extends Transform<DecisionActionVo, DecisionAction>  {

	private static DecisionActionTransform instance = null;
	
	
	private DecisionActionTransform() {
		
	}
	
	
	public static synchronized DecisionActionTransform getInstance() {
		
		if (instance == null) {
			instance = new DecisionActionTransform();
		}
				
		return instance;
	}

	@Override
	public void setDto() {
//		if (instance.getFromDto() == null) {
//			instance.setFromDto(decisionActionVo -> new DecisionAction(decisionActionVo.getRowId(), 
//														  				decisionActionVo.getName(),
//														  				decisionActionVo.getSequence(),
//														  				LogicalOperationTransform.getInstance().createFromDtos(decisionActionVo.getLogicalOperations()),
//														  				decisionActionVo.getDoOption(),
//														  				decisionActionVo.getGroupActionId(),
//														  				decisionActionVo.getNextGroupId()));
//		}
		
	}

	@Override
	public void setEntity() {
//		if (instance.getFromEntity() == null) {
//			instance.setFromEntity(decisionAction -> new DecisionActionVo(decisionAction.getRowId(), 
//															  				decisionAction.getName(),
//															  				decisionAction.getSequence(),
//															  				LogicalOperationTransform.getInstance().createFromEntities(decisionAction.getLogicalOperations()),
//															  				decisionAction.getDoOption(),
//															  				decisionAction.getGroupActionId(),
//															  				decisionAction.getNextGroupId()));
//
//		}
		
	}
	
	
}
