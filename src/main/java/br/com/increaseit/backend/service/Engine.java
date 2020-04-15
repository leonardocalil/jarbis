package br.com.increaseit.backend.service;

import br.com.increaseit.internal.data.entity.Flow;

public interface Engine {
	void execute();
	void execute(Flow flow);
	
}
