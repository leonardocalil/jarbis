package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.FlowVo;
import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.transform.Transform;

public class FlowTransform 
	extends Transform<FlowVo, Flow>  {

	private static FlowTransform instance = null;
	
	private FlowTransform() {
		
	}
	
	
	
	public static synchronized FlowTransform getInstance() {
		
		if (instance == null) {
			instance = new FlowTransform();
			
		}
		
		return instance;
	}
	
	@Override
	public void setDto() {
//		if(instance.getFromDto() == null) {
//			instance.setFromDto(flowVo -> new Flow(flowVo.getRowId(),
//												    flowVo.getName(),
//												    flowVo.getFrequence(),
//												    null,
//												    null,
//												    null,
//												    GroupActionTransform.getInstance().createFromDtos(flowVo.getGroupActions())));
//		
//		
//		}
		
	}

	@Override
	public void setEntity() {
//		if(instance.getFromEntity() == null) {
//			instance.setFromEntity(flow -> new FlowVo(flow.getRowId(),
//													  flow.getName(),
//													  flow.getFrequence(),
//													  null,
//													  null,
//													  null,
//													  GroupActionTransform.getInstance().createFromEntities(flow.getGroupActions())));
//		}
		
	}
	
}
