package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.RelationalOperationVo;
import br.com.increaseit.internal.data.entity.RelationalOperation;
import br.com.increaseit.internal.data.transform.Transform;

public class RelationalOperationTransform extends Transform<RelationalOperationVo, RelationalOperation> {

	private static RelationalOperationTransform instance = null;
	private RelationalOperationTransform() {
		
	}
	
	public static synchronized RelationalOperationTransform getInstance() {
		if (instance == null) {
			instance = new RelationalOperationTransform();
		}
		return instance;
	}

	@Override
	public void setDto() {
		if (instance.getFromDto() == null) {
			instance.setFromDto(relationalOperationVo -> new RelationalOperation(relationalOperationVo.getRowId(),
																				 relationalOperationVo.getName(),
																				 relationalOperationVo.getActionId(),
																				 relationalOperationVo.getOperator(),
																				 relationalOperationVo.getValue(),
																				 relationalOperationVo.getLogicalOperationId()));
		}
		
	}

	@Override
	public void setEntity() {
//		if (instance.getFromEntity() == null) {
//			
//			instance.setFromEntity(relationalOperation -> new RelationalOperationVo(relationalOperation.getRowId(),
//																					relationalOperation.getName(),
//																					relationalOperation.getActionId(),
//																					relationalOperation.getOperator(),
//																					relationalOperation.getValue(),
//																					relationalOperation.getLogicalOperationId()));
//		}
		
	}


	


	
	
	

}
