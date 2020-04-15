package br.com.increaseit.common.vo;

import java.io.Serializable;

import br.com.increaseit.common.util.MyCloneable;


public abstract class ModelVo<T> extends MyCloneable<ModelVo<T>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 597532742589949137L;
	
	protected Long rowId;
	
	protected String name;
	
	protected boolean newObject = false;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.newObject = true;
		this.rowId = rowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rowId == null) ? 0 : rowId.hashCode());
		return result;
	}
	
	
	


	public boolean isNewObject() {
		return newObject;
	}

	public void setNewObject(boolean newObject) {
		this.newObject = newObject;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelVo<?> other = (ModelVo<?>) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rowId == null) {
			if (other.rowId != null)
				return false;
		} else if (!rowId.equals(other.rowId))
			return false;
		return true;
	}

	
	

	
	
}
