package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.GroupAction;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.IRepository;
import br.com.increaseit.internal.data.service.IService;

@Service
public class GroupActionService implements IService<GroupAction> {

	@Autowired
	@Qualifier("groupActionRepository")
	private ARepositoryCustom<GroupAction> repositoryCustom;

	@Autowired
	private IRepository<GroupAction> repository;
	
	
	@PostConstruct
	public void init() {


	}
	
	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}
	
	public GroupAction getById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
		@Override
	public List<GroupAction> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupAction> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupAction save(GroupAction t) {
		return  repository.save(t);
		
	}

	@Override
	public List<GroupAction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
