package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity(name=GroupAction.TABLE_NAME)
@SequenceGenerator(name=GroupAction.SEQUENCE_GENERIC_NAME,sequenceName=GroupAction.SEQUENCE_NAME)
public class GroupAction extends AEntity<GroupAction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6803953547769355029L;
	
	public static final String SEQUENCE_NAME = "SEQ_GROUP_ACTION";
	public static final String TABLE_NAME = "GROUP_ACTION";
	
	public GroupAction() {
		this.actions = new ArrayList<Action>();
		this.decisions = new ArrayList<DecisionAction>();
		this.finalize = null;
		this.name = "Node";
	}
	public GroupAction(Flow flow, DecisionAction decisionAction, String name) {
		this.actions = new ArrayList<Action>();
		this.decisions = new ArrayList<DecisionAction>();
		this.finalize = null;
		this.name = name;
		this.flow = flow;
		this.decisionAction = decisionAction;
	}
	/*
	public GroupAction(Long rowId, String name, String description, String url, 
					  List<Action> actions, List<DecisionAction> decisions,
					  Finalize finalize, Long flowId, Long decisionActionId) {
		this.setRowId(rowId);
		this.name = name;
		this.description = description;
		this.url = url;
		this.actions = actions;
		this.decisions = decisions;
		this.finalize = finalize;
	}*/
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="URL")
	private String url;
	
	@OneToMany(mappedBy="groupAction", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@OrderBy("sequence asc")
	private List<Action> actions;
	
	@OneToMany(mappedBy="groupAction", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST )
	private List<DecisionAction> decisions;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="DECISION_ACTION_ID")
    private DecisionAction decisionAction;
	
	@Transient
	private Finalize finalize;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="FLOW_ID")
    private Flow flow;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public List<Action> getActions() {
		if(actions == null) {
			actions = new ArrayList<Action>();
		}
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Finalize getFinalize() {
		return finalize;
	}
	public void setFinalize(Finalize finalize) {
		this.finalize = finalize;
	}

	public List<DecisionAction> getDecisions() {
		if(decisions == null) {
			decisions = new ArrayList<DecisionAction>();
		}
		return decisions;
	}

	public void setDecisions(List<DecisionAction> decisions) {
		this.decisions = decisions;
	}
	
	 

	
	
	
	public DecisionAction getDecisionAction() {
		return decisionAction;
	}
	public void setDecisionAction(DecisionAction decisionAction) {
		this.decisionAction = decisionAction;
	}
	
	
	
	public Flow getFlow() {
		return flow;
	}
	public void setFlow(Flow flow) {
		this.flow = flow;
	}
	@Override
	public String toString() {
//		return "GroupAction [description=" + description + ", url=" + url + ", actions=" + actions + ", decisions="
//				+ decisions + ", decisionAction=" + decisionAction + ", finalize=" + finalize 
//				+ ", getUrl()=" + getUrl() + ", getActions()=" + getActions() + ", getDescription()=" + getDescription()
//				+ ", getFinalize()=" + getFinalize() + ", getDecisions()=" + getDecisions() + ", getDecisionAction()="
//				+ getDecisionAction() + ", hashCode()=" + hashCode() + ", getRowId()="
//				+ getRowId() + ", getName()=" + getName() + ", isNewObject()=" + isNewObject() + ", getClass()="
//				+ getClass() + ", toString()=" + super.toString() + "]";
		return this.name;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		 return (this.getRowId() != null)
		            ? (this.getClass().hashCode() + this.getRowId().hashCode())
		            : super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {

		 return (other instanceof GroupAction) && (this.getRowId() != null)
		            ? this.getRowId().equals(((GroupAction) other).getRowId())
		            : (other == this);
	}
	
}
