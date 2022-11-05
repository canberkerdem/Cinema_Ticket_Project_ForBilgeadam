package com.cinema.mapper;

import com.cinema.dto.SeansDTO;
import com.cinema.entity.Seans;
import org.mapstruct.Mapper;

@Mapper
public interface SeansMapper extends BaseMapper<Seans, SeansDTO> {
}
