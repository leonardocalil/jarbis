package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.ActionVo;
import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.transform.Transform;

public class ActionTransform 
	extends Transform<ActionVo, Action>  {

	private static ActionTransform instance = null;
	
	private ActionTransform() {
		
	}
	
	
	
	public static synchronized ActionTransform getInstance() {
		
		if (instance == null) {
			instance = new ActionTransform();
			
		}
		
		return instance;
	}
	
	@Override
	public void setDto() {
//		if(instance.getFromDto() == null) {
//			instance.setFromDto(actionVo -> new Action(actionVo.getRowId(),
//													   actionVo.getName(),
//													   actionVo.getGroupActionId(),
//													   actionVo.getFieldType(),
//													   actionVo.getFieldName(),						 					  
//													   actionVo.getDoAction(),
//													   actionVo.getTypeWrite(),
//													   ParameterTransform.getInstance().convertFromDto(actionVo.getParameter()),
//													   WaitTransform.getInstance().convertFromDto(actionVo.getPreAction()),
//													   WaitTransform.getInstance().convertFromDto(actionVo.getPosAction()),
//													   actionVo.getWaitPreAction(),
//													   actionVo.getWaitPosAction()));
//		}
		
	}

	@Override
	public void setEntity() {
//		if(instance.getFromEntity() == null) {
//			instance.setFromEntity(action -> new ActionVo_(action.getRowId(),
//														  action.getName(),
//														  action.getGroupActionId(),
//														  action.getDoAction(),
//														  action.getTypeWrite(),
//														  ParameterTransform.getInstance().convertFromEntity(action.getParameter()),
//														  WaitTransform.getInstance().convertFromEntity(action.getPreAction()),
//														  WaitTransform.getInstance().convertFromEntity(action.getPosAction()),
//														  action.getWaitPreAction(),
//														  action.getWaitPosAction()));
//		}
		
	}
	
}
