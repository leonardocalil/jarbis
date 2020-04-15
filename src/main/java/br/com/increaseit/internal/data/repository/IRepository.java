package br.com.increaseit.internal.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.increaseit.internal.data.entity.AEntity;


public interface IRepository <T extends AEntity<T>> 
	extends CrudRepository<T, Long> {
	
}
