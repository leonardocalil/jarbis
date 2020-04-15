package br.com.increaseit.internal.data.transform;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @param <T>
 *            DTO representation's type
 * @param <U>
 *            Domain representation's type
 */
public abstract class Transform<T, U> {

	private Function<T, U> fromDto;
	private Function<U, T> fromEntity;

	/**
	 * @param fromDto
	 *            Function that converts given dto entity into the domain entity.
	 * @param fromEntity
	 *            Function that converts given domain entity into the dto entity.
	 */
//	public Transform(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
//		this.fromDto = fromDto;
//		this.fromEntity = fromEntity;
//	}

	/**
	 * 
	 * @param fromDto
	 *            Function that converts given dto entity into the domain entity.
	 */
	public void setFromDto(Function<T, U> fromDto) {
		this.fromDto = fromDto;
	}
	public Function<T, U> getFromDto() {
		return this.fromDto;
	}

	/**
	 * 
	 * @param fromEntity
	 *            Function that converts given domain entity into the dto entity.
	 */
	public void setFromEntity(Function<U, T> fromEntity) {
		this.fromEntity = fromEntity;
	}
	public Function<U, T> getFromEntity() {
		return this.fromEntity;
	}

	/**
	 * @param dto
	 *            DTO entity
	 * @return The domain representation - the result of the converting function
	 *         application on dto entity.
	 */
	public final U convertFromDto(final T dto) {
		if (dto == null)
			return null;
		setDto();
		return fromDto.apply(dto);
	}

	/**
	 * @param entity
	 *            domain entity
	 * @return The DTO representation - the result of the converting function
	 *         application on domain entity.
	 */
	public final T convertFromEntity(final U entity) {
		if (entity == null)
			return null;
		setEntity();
		return fromEntity.apply(entity);
	}

	/**
	 * @param dtos
	 *            collection of DTO entities
	 * @return List of domain representation of provided entities retrieved by
	 *         mapping each of them with the conversion function
	 */
	public final List<U> createFromDtos(final Collection<T> dtos) {
		if (dtos == null || dtos.size() == 0) {
			return null;
		}
		setDto();
		return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
	}

	/**
	 * @param entities
	 *            collection of domain entities
	 * @return List of domain representation of provided entities retrieved by
	 *         mapping each of them with the conversion function
	 */
	public final List<T> createFromEntities(final Collection<U> entities) {
		if (entities == null || entities.size() == 0) {
			return null;
		}
		setEntity();
		return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
	}
	
	public abstract void setDto();
	public abstract void setEntity();
}
