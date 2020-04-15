package br.com.increaseit.internal.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


@MappedSuperclass
@Inheritance
public abstract class AEntity<T> implements Serializable, Cloneable {

	private static final long serialVersionUID = 597532642589949137L;
	
	public static final String OWNER_NAME = "public";
	
	public static final String SEQ_VIRTUAL_ID = "SEQ_VIRTUAL_ID";
	
	public static final String SEQUENCE_GENERIC_NAME = "sequence";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=AEntity.SEQUENCE_GENERIC_NAME)
	@Column(name="ROW_ID")
	private Long rowId;
	
	@Column(name="NAME")
	protected String name;
	
	@Transient
	protected boolean newObject = false;
	
	@Transient
	protected boolean edited = false;
	
	
	@Transient
	protected Long virtualRowId;

	public Long getRowId() {
		if (rowId != null) {
			return rowId;
		} 
		return this.virtualRowId;
	}

	public void setRowId(Long rowId) {
		this.newObject = true;
		this.virtualRowId = rowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isNewObject() {
		if(rowId != null) {
			return false;
		}
		return newObject;
	}

	public void setNewObject(boolean newObject) {
		this.newObject = newObject;
	}
	
	

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rowId == null) ? 0 : rowId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AEntity<?> other = (AEntity<?>) obj;
		if (rowId == null) {
			if (other.rowId != null)
				return false;
		} else if (!rowId.equals(other.rowId))
			return false;
		return true;
	}
	@SuppressWarnings("unchecked")
	public T clone() throws CloneNotSupportedException {
		return (T) super.clone();		    
    }

	


	
	

	
	
}
