package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.RepositoryAction;
import br.com.increaseit.internal.data.service.IService;

@Service
public class ActionService implements IService<Action> {

	@Autowired
	@Qualifier("actionRepository")
	private ARepositoryCustom<Action> repositoryCustom;

	@Autowired
	private RepositoryAction repository;
	
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}
	
	public Action getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Action> findByName(String name) {
		return null;
	}

	@Override
	public List<Action> findByNameContaining(String name) {
		return null;
	}

	@Override
	public Action save(Action t) {
		return repository.save(t);
	}

	@Override
	public List<Action> findAll() {
		return null;
	}
	public void updateSequence(Action entity) {
		repository.save(entity);
	}
	
}
