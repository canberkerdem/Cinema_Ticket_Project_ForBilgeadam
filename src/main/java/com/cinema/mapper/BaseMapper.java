package com.cinema.mapper;

import com.cinema.dto.BaseDTO;
import com.cinema.entity.BaseEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

public interface BaseMapper<Entity extends BaseEntity, DTO extends BaseDTO> {

    @Named("toEntity")
    @Mapping(target = "creationDate", ignore = true)
    Entity toEntity(DTO dto);

    @Named("toDTO")
    DTO toDTO(Entity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    Set<Entity> toEntitySet(Set<DTO> dtoSet);

    @IterableMapping(qualifiedByName = "toDto")
    Set<DTO> toDTOSet(Set<Entity> entitySet);
}
