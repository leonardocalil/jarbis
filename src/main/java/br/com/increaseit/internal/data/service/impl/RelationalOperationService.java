package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.RelationalOperation;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.IRepository;
import br.com.increaseit.internal.data.service.IService;

@Service
public class RelationalOperationService implements IService<RelationalOperation> {

	@Autowired
	@Qualifier("relationalOperationRepository")
	private ARepositoryCustom<RelationalOperation> repositoryCustom;

	@Autowired
	private IRepository<RelationalOperation> repository;
	
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}
	
	public RelationalOperation getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<RelationalOperation> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RelationalOperation> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RelationalOperation save(RelationalOperation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RelationalOperation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
