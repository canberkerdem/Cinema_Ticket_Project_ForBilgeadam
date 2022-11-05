package com.cinema.mapper;

import com.cinema.dto.MovieDTO;
import com.cinema.entity.Movie;
import org.mapstruct.Mapper;

@Mapper
public interface MovieMapper extends BaseMapper<Movie, MovieDTO> {
}
