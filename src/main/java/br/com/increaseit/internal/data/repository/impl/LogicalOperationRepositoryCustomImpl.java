package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.LogicalOperation;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("logicalOperationRepository")
public class LogicalOperationRepositoryCustomImpl extends ARepositoryCustom<LogicalOperation>{

	@Override
	protected String getSequenceName() {
		return LogicalOperation.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return LogicalOperation.class.getName();
	}
	
}
