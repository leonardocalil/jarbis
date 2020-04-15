package br.com.increaseit.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.increaseit.backend.service.Engine;


//@SpringBootApplication
//@ComponentScan("br.com.increaseit.backend.*")
@Configuration
@EnableScheduling
public class MainBackend{
	
	@Autowired
	private Engine engine;
	
	@Scheduled(fixedDelay = 30000)
	public void scheduleFixedDelayTask() {
	    System.out.println(
	      "Fixed delay task - " + System.currentTimeMillis() / 1000);
	    engine.execute();
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
}
