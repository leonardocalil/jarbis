package br.com.increaseit.internal.data.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.increaseit.internal.data.entity.AEntity;

public abstract class ARepositoryCustom<T extends AEntity<T>>  {
	
	@PersistenceContext 
	protected EntityManager em;
	
	protected abstract String getSequenceName();
	
	protected abstract String getTableName();
	
	public Long getNextRowId() {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT nextval('");
		sql.append(T.OWNER_NAME);
		sql.append(".");
		sql.append(getSequenceName());
		sql.append("')");
		
		Query query = em.createNativeQuery(sql.toString());
		return ((java.math.BigInteger)query.getSingleResult()).longValue();
	}
	
	
	
	
}
