package br.com.increaseit.internal.data.transform.impl;

import br.com.increaseit.common.vo.FinalizeVo;
import br.com.increaseit.internal.data.entity.Finalize;
import br.com.increaseit.internal.data.transform.Transform;

public class FinalizeTransform 
	extends Transform<FinalizeVo, Finalize>  {

	private static FinalizeTransform instance = null;
	
	private FinalizeTransform() {
	}
	
	public static synchronized FinalizeTransform getInstance() {
		if (instance == null) {
			instance = new FinalizeTransform();
			
			
		}
		return instance;
	}

	@Override
	public void setDto() {
		if (instance.getFromDto() == null) {
			instance.setFromDto(finalizeVo -> new Finalize(finalizeVo.getRowId(),
						finalizeVo.getName()));
		}
		
	}

	@Override
	public void setEntity() {
		if (instance.getFromEntity() == null) {
			instance.setFromEntity(finalize -> new FinalizeVo(finalize.getRowId(),
					finalize.getName()));
		}
		
	}
	
}
