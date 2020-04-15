package br.com.increaseit.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.backend.service.Engine;
import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.service.impl.FlowService;

@Service("engine")
public class EngineImpl implements Engine{

	@Autowired
	@Qualifier(value="threadEngine")
	private Engine thread;
	
	@Autowired(required=false)
	private FlowService service;
	

	public void execute(Flow flow) {
		
	}
	
	public void execute() {
		thread.execute();
		
		List<Flow> flows = service.findAllReadyToExecute();
		if(flows != null && flows.size() > 0) {
			for(Flow flow : flows) {
				thread.execute(flow);
			}			
		}

	}

}
