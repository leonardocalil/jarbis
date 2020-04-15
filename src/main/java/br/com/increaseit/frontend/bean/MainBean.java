package br.com.increaseit.frontend.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.increaseit.backend.service.Engine;
import br.com.increaseit.backend.service.impl.EngineImpl;
import br.com.increaseit.frontend.util.ApplicationContextProvider;

/**
 * @author leonardo
 *
 */
@ManagedBean
@ViewScoped
public class MainBean {
	
	private Engine engine;
	
    @PostConstruct
    public void init() {
    	this.engine = ApplicationContextProvider.getBean("engine", EngineImpl.class);
    }
	       
    
    public void execute() {
    	engine.execute();
    	
    }
    public void execute1() {
    	engine.execute();
    	
    }

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
    
    

    
}
