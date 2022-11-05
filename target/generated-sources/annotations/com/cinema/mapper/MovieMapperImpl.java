package com.cinema.mapper;

import com.cinema.dto.MovieDTO;
import com.cinema.entity.Movie;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T02:48:58+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public Movie toEntity(MovieDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId( dto.getId() );
        movie.setStartTime( dto.getStartTime() );
        movie.setEndTime( dto.getEndTime() );
        movie.setMinAge( dto.getMinAge() );
        movie.setMaxAge( dto.getMaxAge() );
        movie.setPrice( dto.getPrice() );

        return movie;
    }

    @Override
    public MovieDTO toDTO(Movie entity) {
        if ( entity == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setId( entity.getId() );
        movieDTO.setCreationDate( entity.getCreationDate() );
        movieDTO.setStartTime( entity.getStartTime() );
        movieDTO.setEndTime( entity.getEndTime() );
        movieDTO.setMinAge( entity.getMinAge() );
        movieDTO.setMaxAge( entity.getMaxAge() );
        movieDTO.setPrice( entity.getPrice() );

        return movieDTO;
    }

    @Override
    public Set<Movie> toEntitySet(Set<MovieDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Movie> set = new HashSet<Movie>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( MovieDTO movieDTO : dtoSet ) {
            set.add( toEntity( movieDTO ) );
        }

        return set;
    }

    @Override
    public Set<MovieDTO> toDTOSet(Set<Movie> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<MovieDTO> set = new HashSet<MovieDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Movie movie : entitySet ) {
            set.add( toDTO( movie ) );
        }

        return set;
    }
}
