package com.cinema.mapper;

import com.cinema.dto.AudienceDTO;
import com.cinema.entity.Audience;
import org.mapstruct.Mapper;

@Mapper
public interface AudienceMapper extends BaseMapper<Audience, AudienceDTO> {
}
