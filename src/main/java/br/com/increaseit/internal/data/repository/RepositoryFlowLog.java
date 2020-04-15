package br.com.increaseit.internal.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.increaseit.internal.data.entity.FlowLog;

public interface RepositoryFlowLog extends CrudRepository<FlowLog, Long> {
	
}
