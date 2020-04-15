package br.com.increaseit.internal.data.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.increaseit.internal.data.entity.Action;

public interface RepositoryAction extends CrudRepository<Action, Long> {
	
	
	
}
