package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.LogicalOperationVo;
import br.com.increaseit.internal.data.entity.LogicalOperation;
import br.com.increaseit.internal.data.transform.Transform;

public class LogicalOperationTransform extends Transform<LogicalOperationVo, LogicalOperation> {

	private static LogicalOperationTransform instance = null;
	
	private LogicalOperationTransform() {
		
	}
	
	public static synchronized LogicalOperationTransform getInstance() {
		if (instance == null) {
			instance = new LogicalOperationTransform();
			
						
			
		}
		return instance;
	}

	@Override
	public void setDto() {

		if (instance.getFromDto() == null) {
			instance.setFromDto(logicalOperationVo -> new LogicalOperation(logicalOperationVo.getRowId(),
																			logicalOperationVo.getName(), 
																			logicalOperationVo.getDecisionActionId(),
																			logicalOperationVo.getLogicalOperator(),
																			RelationalOperationTransform.getInstance().createFromDtos(logicalOperationVo.getOperations())));

		}
		
	}

	@Override
	public void setEntity() {

//		if (instance.getFromEntity() == null) {
//			instance.setFromEntity(logicalOperation -> new LogicalOperationVo(logicalOperation.getRowId(),
//																				logicalOperation.getName(), 
//																				logicalOperation.getDecisionActionId(),
//																				logicalOperation.getLogicalOperator(),
//																				RelationalOperationTransform.getInstance().createFromEntities(logicalOperation.getOperations())));
//		}
		
	}
	
}
