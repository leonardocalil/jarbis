package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("flowRepository")
public class FlowRepositoryCustomImpl extends ARepositoryCustom<Flow>{

	@Override
	protected String getSequenceName() {
		return Flow.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return Flow.class.getSimpleName();
	}
	
}
