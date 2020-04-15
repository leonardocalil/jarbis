package br.com.increaseit.frontend.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import br.com.increaseit.common.util.Messages;
import br.com.increaseit.internal.data.entity.AEntity;

public class FrontendBean {

	
	public String getMessage(final String key) {
		return Messages.getInstance().getMessage(key);
	}
	
	
	public void addInfoMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	public void addWarningMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, message, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	public void addErrorMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public void executeScripts(String script) {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript(script);
	}
	public void setEdited(AEntity<?> entity) {
		entity.setEdited(true);
	}
}
