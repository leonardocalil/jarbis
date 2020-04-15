package br.com.increaseit.internal.data.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.increaseit.common.constants.LogStatus;
import br.com.increaseit.internal.data.entity.FlowLog;
import br.com.increaseit.internal.data.repository.RepositoryFlowLog;
import br.com.increaseit.internal.data.service.IService;

@Service
@Transactional
public class FlowLogService implements IService<FlowLog> {

	@Autowired
	private RepositoryFlowLog repository;
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return null;
	}

	@Override
	public FlowLog getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<FlowLog> findByName(String name) {
		return null;
	}

	@Override
	public List<FlowLog> findByNameContaining(String name) {
		return null;
	}

	@Override
	public FlowLog save(FlowLog entity) {
		return repository.save(entity);
	}

	@Override
	public List<FlowLog> findAll() {
		return (List<FlowLog>) repository.findAll();
	}
	
	public FlowLog startLog(Long flowId, 
							Long groupId, 
							Long actionId, 
							Long waitId, 
							Long decisionId,
							String name) {
		FlowLog log = new FlowLog();
		log.setFlowId(flowId);
		log.setGroupActionId(groupId);
		log.setStepActionId(actionId);
		log.setWaitId(waitId);
		log.setDecisionId(decisionId);
		log.setName(name);
		log.setStartedDatetime(Calendar.getInstance().getTime());
		log.setStatus(LogStatus.SUCCESS);
		return repository.save(log);
	}
	public void finishLog(FlowLog log) {
		log.setFinishedDatetime(Calendar.getInstance().getTime());
		repository.save(log);
	}
	
		
}
