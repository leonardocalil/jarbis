package br.com.increaseit.common.vo;

public class FinalizeVo extends ModelVo<FinalizeVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6482705607096781787L;

	public FinalizeVo() {
		
	}
	
	public FinalizeVo(Long rowId, String name) {
		this.rowId = rowId;
		this.name = name;
	}
	
	@Override
	protected Class<FinalizeVo> getInstance() {
		// TODO Auto-generated method stub
		return FinalizeVo.class;
	}

}
