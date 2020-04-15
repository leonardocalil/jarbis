package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.DecisionAction;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.IRepository;
import br.com.increaseit.internal.data.service.IService;

@Service
public class DecisionActionService implements IService<DecisionAction> {

	@Autowired
	@Qualifier("decisionActionRepository")
	private ARepositoryCustom<DecisionAction> repositoryCustom;

	@Autowired
	private IRepository<DecisionAction> repository;
	
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}
	
	public DecisionAction getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<DecisionAction> findByName(String name) {
		return null;
	}

	@Override
	public List<DecisionAction> findByNameContaining(String name) {
		return null;
	}

	@Override
	public DecisionAction save(DecisionAction t) {
		return repository.save(t);
	}

	@Override
	public List<DecisionAction> findAll() {
		return null;
	}
	
}
