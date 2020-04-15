package br.com.increaseit.common.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.util.Constants;
import br.com.increaseit.common.util.Messages;

public class GroupActionVo extends ModelVo<GroupActionVo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6254384123086160304L;
	private String description;
	private String url;
	private List<ActionVo> actions;
	
	private List<DecisionActionVo> decisions;
	private FinalizeVo finalize;
	private Long flowId;
	private Long decisionActionId;
	
	
	public GroupActionVo(Long flowId) {
		this.actions = new ArrayList<ActionVo>();
		this.decisions = new ArrayList<DecisionActionVo>();
		this.finalize = null;
		this.decisionActionId = null;
		this.flowId = flowId;
		this.name = Messages.getInstance().getMessage(Constants.MESSAGE_NAME_DECISION_GROUP_DEFAULT);
	}
	public GroupActionVo(Long flowId, Long decisionActionId, String name) {
		this.actions = new ArrayList<ActionVo>();
		this.decisions = new ArrayList<DecisionActionVo>();
		this.finalize = null;
		this.decisionActionId = null;
		this.flowId = flowId;
		this.decisionActionId = decisionActionId;
		this.name = name;
	}
	
	
	
	public GroupActionVo(Long rowId, String name, String description, String url, 
						List<ActionVo> actions, List<DecisionActionVo> decisions,
						FinalizeVo finalize, Long flowId, Long decisionActionId) {
		super();
		this.rowId = rowId;
		this.name = name;
		this.description = description;
		this.url = url;
		this.actions = actions;
		this.decisions = decisions;
		this.finalize = finalize;
		this.flowId = flowId;
		this.decisionActionId = decisionActionId;
	}
	@Override
	protected Class<GroupActionVo> getInstance() {
		// TODO Auto-generated method stub
		return GroupActionVo.class;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public List<ActionVo> getActions() {
		return actions;
	}

	public void setActions(List<ActionVo> actions) {
		this.actions = actions;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FinalizeVo getFinalize() {
		return finalize;
	}
	public void setFinalize(FinalizeVo finalize) {
		this.finalize = finalize;
	}

	public List<DecisionActionVo> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<DecisionActionVo> decisions) {
		this.decisions = decisions;
	}

	@Override
	public String toString() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		 return (rowId != null)
		            ? (this.getClass().hashCode() + rowId.hashCode())
		            : super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {

		 return (other instanceof GroupActionVo) && (rowId != null)
		            ? rowId.equals(((GroupActionVo) other).rowId)
		            : (other == this);
	}
	public Long getDecisionActionId() {
		return decisionActionId;
	}
	public void setDecisionActionId(Long decisionActionId) {
		this.decisionActionId = decisionActionId;
	}
	public Long getFlowId() {
		return flowId;
	}
	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}

	
	
	
	
	
}
