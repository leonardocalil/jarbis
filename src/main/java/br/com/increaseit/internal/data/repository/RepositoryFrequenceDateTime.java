package br.com.increaseit.internal.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.increaseit.internal.data.entity.FrequenceDateTime;

public interface RepositoryFrequenceDateTime extends CrudRepository<FrequenceDateTime, Long> {
	
	
}
