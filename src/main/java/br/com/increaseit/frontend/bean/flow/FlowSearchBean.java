package br.com.increaseit.frontend.bean.flow;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.NamedEntityGraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.increaseit.frontend.bean.FrontendBean;
import br.com.increaseit.frontend.util.ApplicationContextProvider;
import br.com.increaseit.internal.data.entity.Flow;
import br.com.increaseit.internal.data.service.impl.FlowService;

@ManagedBean(name="flowSearch")
@ViewScoped
public class FlowSearchBean extends FrontendBean {

	private String nameSearch;
	private String filtered;

	private List<Flow> flows;
	
//	@Autowired
	private FlowService flowService;
	
	@PostConstruct
	public void init() {
		this.flowService = ApplicationContextProvider.getBean("flowService", FlowService.class);
	}
	
	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}
	
	
	
	public String getFiltered() {
		return filtered;
	}

	public void setFiltered(String filtered) {
		this.filtered = filtered;
	}

	
	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	public void search() {
		if (nameSearch != null && nameSearch.length() > 0) {
			this.flows = this.flowService.findByNameContaining(nameSearch);
		} else {
			this.flows = this.flowService.findAll();
		}
		
	}
	

	
}
