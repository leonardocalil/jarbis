package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.LogicalOperation;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.IRepository;
import br.com.increaseit.internal.data.service.IService;

@Service
public class LogicalOperationService implements IService<LogicalOperation> {

	@Autowired
	@Qualifier("logicalOperationRepository")
	private ARepositoryCustom<LogicalOperation> repositoryCustom;

	@Autowired
	private IRepository<LogicalOperation> repository;
	
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}
	
	public LogicalOperation getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<LogicalOperation> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogicalOperation> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicalOperation save(LogicalOperation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogicalOperation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
