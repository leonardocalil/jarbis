package br.com.increaseit.internal.data.entity;

public class Finalize extends AEntity<Finalize> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8430712219597471307L;


	public static final String SEQUENCE_NAME = "SEQ_FINALIZE";
	
	public static final String TABLE_NAME = "FINALIZE";

	public Finalize() {
		
	}
	
	public Finalize(Long rowId, String name) {
		this.setRowId(rowId);
		this.name = name;
	}

	
}
