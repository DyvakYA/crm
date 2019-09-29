package com.dyvak.crm.mapper;

import java.util.List;

public interface BaseMapper<D, E> {

    D toDto(E entity);

    List<D> toDto(List<E> entities);

    E toEntity(D dto);

    List<E> toEntity(List<D> dtos);

}
