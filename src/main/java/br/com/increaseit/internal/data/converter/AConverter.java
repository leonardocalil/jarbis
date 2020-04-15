package br.com.increaseit.internal.data.converter;

public abstract class AConverter<E, M> {
	public abstract E getEntity();
	public abstract M getModel();
	
	
}
