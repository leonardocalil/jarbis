package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.FrequenceInterval;
import br.com.increaseit.internal.data.entity.Schedule;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.RepositoryFrequenceInterval;
import br.com.increaseit.internal.data.service.IService;

@Service
public class FrequenceIntervalService implements IService<FrequenceInterval> {

	@Autowired
	@Qualifier("scheduleRepository")
	private ARepositoryCustom<Schedule> repositoryCustom;

	@Autowired
	private RepositoryFrequenceInterval repository;
	
	@PostConstruct
	public void init() {


	}

	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}

	@Override
	public FrequenceInterval getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<FrequenceInterval> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrequenceInterval> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FrequenceInterval save(FrequenceInterval t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrequenceInterval> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
