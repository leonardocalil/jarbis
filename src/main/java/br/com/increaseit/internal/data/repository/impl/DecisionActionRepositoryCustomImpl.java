package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.DecisionAction;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("decisionActionRepository")
public class DecisionActionRepositoryCustomImpl extends ARepositoryCustom<DecisionAction> {

	@Override
	protected String getSequenceName() {
		return DecisionAction.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return DecisionAction.class.getName();
	}

		
}
