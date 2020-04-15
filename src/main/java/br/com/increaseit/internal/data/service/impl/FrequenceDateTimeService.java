package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.FrequenceDateTime;
import br.com.increaseit.internal.data.entity.Schedule;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.RepositoryFrequenceDateTime;
import br.com.increaseit.internal.data.service.IService;

@Service
public class FrequenceDateTimeService implements IService<FrequenceDateTime> {

	@Autowired
	@Qualifier("scheduleRepository")
	private ARepositoryCustom<Schedule> repositoryCustom;

	@Autowired
	private RepositoryFrequenceDateTime repository;
	
	@PostConstruct
	public void init() {


	}

	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}

	@Override
	public FrequenceDateTime getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<FrequenceDateTime> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrequenceDateTime> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FrequenceDateTime save(FrequenceDateTime t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrequenceDateTime> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
