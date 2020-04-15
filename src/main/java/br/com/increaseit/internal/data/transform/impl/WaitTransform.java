package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.WaitVo;
import br.com.increaseit.internal.data.entity.Wait;
import br.com.increaseit.internal.data.transform.Transform;

public class WaitTransform 
	extends Transform<WaitVo, Wait>  {

	private static WaitTransform instance = null;
	
	private WaitTransform() {
	}
	
	public static synchronized WaitTransform getInstance() {
		if (instance == null) {
			instance = new WaitTransform ();
			
			
		}
		return instance;
	}

	@Override
	public void setDto() {
//		if (instance.getFromDto() == null) {
//			instance.setFromDto(waitVo -> new Wait(waitVo.getRowId(),
//										   			  waitVo.getName(),
//										   			  waitVo.getFieldType(),
//										   			  waitVo.getFieldName(),
//										   			  waitVo.getTimeOut(),
//										   			  waitVo.getActionId()));
//		}
		
	}

	@Override
	public void setEntity() {
//		if (instance.getFromEntity() == null) {
//			instance.setFromEntity(wait -> new WaitVo(wait.getRowId(),
//											   			  wait.getName(),
//											   			  wait.getFieldType(),
//											   			  wait.getFieldName(),
//											   			  wait.getTimeOut(),
//											   			  wait.getActionId()));
//		}
		
	}
		
}
