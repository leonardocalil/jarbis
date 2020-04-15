package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.ParameterVo;
import br.com.increaseit.internal.data.entity.Parameter;
import br.com.increaseit.internal.data.transform.Transform;

public class ParameterTransform 
	extends Transform<ParameterVo, Parameter>  {

	private static ParameterTransform instance = null;
	
	
	private ParameterTransform() {
		
	}
	
	
	
	public static synchronized ParameterTransform getInstance() {
		if (instance == null) {
			instance = new ParameterTransform();
		
		}
		
		
		return instance;
	}
	

	@Override
	public void setDto() {
//		if (instance.getFromDto() == null) {
//			instance.setFromDto(parameterVo -> new Parameter(parameterVo.getRowId(),
//																parameterVo.getName(),
//																parameterVo.getGroupActionId(),
//																parameterVo.getActionId(),
//																parameterVo.getText()));
//		}
		
	}

	@Override
	public void setEntity() {
//		if (instance.getFromEntity() == null) {
//			instance.setFromEntity(parameter -> new ParameterVo(parameter.getRowId(),
//																	parameter.getName(),
//																	parameter.getGroupId(),
//																	parameter.getActionId(),
//																	parameter.getText()));
//		}
		
	}
	
	
	
	
}
