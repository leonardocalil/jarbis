package br.com.increaseit.internal.data.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.FrequenceWeekDay;
import br.com.increaseit.internal.data.entity.Schedule;
import br.com.increaseit.internal.data.repository.ARepositoryCustom;
import br.com.increaseit.internal.data.repository.RepositoryFrequenceWeekDay;
import br.com.increaseit.internal.data.service.IService;

@Service
public class FrequenceWeekDayService implements IService<FrequenceWeekDay> {

	@Autowired
	@Qualifier("scheduleRepository")
	private ARepositoryCustom<Schedule> repositoryCustom;

	@Autowired
	private RepositoryFrequenceWeekDay repository;
	
	@PostConstruct
	public void init() {


	}

	@Override
	public Long getNextRowId() {
		return repositoryCustom.getNextRowId();
	}

	@Override
	public FrequenceWeekDay getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<FrequenceWeekDay> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrequenceWeekDay> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FrequenceWeekDay save(FrequenceWeekDay t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrequenceWeekDay> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
