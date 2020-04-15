package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.RelationalOperation;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("relationalOperationRepository")
public class RelationalOperationRepositoryCustomImpl extends ARepositoryCustom<RelationalOperation>{

	@Override
	protected String getSequenceName() {
		return RelationalOperation.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return RelationalOperation.class.getName();
	}
	
}
