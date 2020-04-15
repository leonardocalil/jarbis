package br.com.increaseit.internal.data.service;

import java.util.List;

import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.entity.Schedule;

public interface IService <T> {

	Long getNextRowId();
	
	T getById(Long id);
	
	List<T> findByName(String name);
	
	List<T> findByNameContaining(String name);
	
	T save(T entity);
	
	List<T> findAll();
	
}
