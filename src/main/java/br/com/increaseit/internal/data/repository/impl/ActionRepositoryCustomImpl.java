package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("actionRepository")
public class ActionRepositoryCustomImpl extends ARepositoryCustom<Action>{

	@Override
	protected String getSequenceName() {
		return Action.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return Action.class.getName();
	}
	
}
