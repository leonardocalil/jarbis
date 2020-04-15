package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.RepositoryFlow;
import br.com.increaseit.internal.data.service.IService;

@Service
@Transactional
public class FlowService implements IService<Flow> {

	@Autowired
	@Qualifier("flowRepository")
	private ARepositoryCustom<Flow> repositoryCustom;

	@Autowired
	private RepositoryFlow repository;
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}
	public Flow getById(Long id) {
		return repository.findById(id).orElse(null);
	}
	public List<Flow> findByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}
	public List<Flow> findByNameContaining(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}
	public List<Flow> findAllReadyToExecute() {
		
		return repository.findAllReadyToExecute();
	}
	
	public List<Flow> findAllFinishedRecurrence() {
		
		return repository.findAllFinishedRecurrence();
	}
		
	public Flow save(Flow flow) {
		return repository.save(flow);
		
	}
	public List<Flow> findAll() {
		return (List<Flow>) repository.findAll();
	}
		
}
