package br.com.increaseit.internal.data.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.entity.Schedule;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;

@Repository("scheduleRepository")
public class ScheduleRepositoryCustomImpl extends ARepositoryCustom<Schedule>{

	@Override
	protected String getSequenceName() {
		return Action.SEQUENCE_NAME;
	}

	@Override
	protected String getTableName() {
		return Schedule.class.getSimpleName();
	}
	
}
