package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.GroupActionVo;
import br.com.increaseit.internal.data.entity.GroupAction;
import br.com.increaseit.internal.data.transform.Transform;

public class GroupActionTransform 
	extends Transform<GroupActionVo, GroupAction>  {

	private static GroupActionTransform instance = null;
	
	private GroupActionTransform() {
		
	}
	
	public static synchronized GroupActionTransform getInstance() {
		if (instance == null) {
			instance = new GroupActionTransform();			
			
		}
		
		return instance;
	}
	
	@Override
	public void setDto() {
//		if (instance.getFromDto() == null) {
//			instance.setFromDto(groupActionVo -> new GroupAction(groupActionVo.getRowId(),
//					 											 groupActionVo.getName(),
//					 											 groupActionVo.getDescription(),
//					 											 groupActionVo.getUrl(),
//					 											 ActionTransform.getInstance().createFromDtos(groupActionVo.getActions()),
//					 											 DecisionActionTransform.getInstance().createFromDtos(groupActionVo.getDecisions()),
//					 											 FinalizeTransform.getInstance().convertFromDto(groupActionVo.getFinalize()),
//					 											 groupActionVo.getFlowId(),
//					 											 groupActionVo.getDecisionActionId()));
//		}
		
	}

	@Override
	public void setEntity() {
//		if(instance.getFromEntity() == null) {
//			instance.setFromEntity(groupAction -> new GroupActionVo_(groupAction.getRowId(),
//																	groupAction.getName(),
//																	groupAction.getDescription(),
//																	groupAction.getUrl(),
//																	ActionTransform.getInstance().createFromEntities(groupAction.getActions()),
//																	DecisionActionTransform.getInstance().createFromEntities(groupAction.getDecisions()),
//																	FinalizeTransform.getInstance().convertFromEntity(groupAction.getFinalize()),
//																	groupAction.getFlowId(),
//																	groupAction.getDecisionActionId()));
//		}
		
	}
		
	
}
