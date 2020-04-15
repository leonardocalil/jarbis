package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.Parameter;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.IRepository;
import br.com.increaseit.internal.data.service.IService;

@Service
public class ParameterService implements IService<Parameter> {

	@Autowired
	@Qualifier("parameterRepository")
	private ARepositoryCustom<Parameter> repositoryCustom;

	@Autowired
	private IRepository<Parameter> repository;
	
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}
	
	public Parameter getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Parameter> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parameter> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parameter save(Parameter t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parameter> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
