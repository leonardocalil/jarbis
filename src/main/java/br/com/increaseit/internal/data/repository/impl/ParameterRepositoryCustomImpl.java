package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.Parameter;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("parameterRepository")
public class ParameterRepositoryCustomImpl extends ARepositoryCustom<Parameter>{

	@Override
	protected String getSequenceName() {
		return Parameter.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return Parameter.class.getName();
	}
	
}
