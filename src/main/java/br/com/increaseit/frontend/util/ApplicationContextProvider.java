package br.com.increaseit.frontend.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		ApplicationContextProvider.context = appContext;
	}
	public  static <T> T getBean(String name, Class<T> aClass){
        return context.getBean(name,aClass);
    }
	
	public static ApplicationContext getApplicationContext() {
	    return context;
	}


}
