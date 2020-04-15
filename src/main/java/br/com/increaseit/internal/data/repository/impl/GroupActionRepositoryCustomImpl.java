package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.GroupAction;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("groupActionRepository")
public class GroupActionRepositoryCustomImpl extends ARepositoryCustom<GroupAction> {

	@Override
	protected String getSequenceName() {
		return GroupAction.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return GroupAction.class.getName();
	}
		
}
