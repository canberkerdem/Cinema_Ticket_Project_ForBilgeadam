package com.cinema.mapper;

import com.cinema.dto.SeansDTO;
import com.cinema.entity.Seans;
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
public class SeansMapperImpl implements SeansMapper {

    @Override
    public Seans toEntity(SeansDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Seans seans = new Seans();

        seans.setId( dto.getId() );
        seans.setSeansName( dto.getSeansName() );
        seans.setSeansDate( dto.getSeansDate() );

        return seans;
    }

    @Override
    public SeansDTO toDTO(Seans entity) {
        if ( entity == null ) {
            return null;
        }

        SeansDTO seansDTO = new SeansDTO();

        seansDTO.setId( entity.getId() );
        seansDTO.setCreationDate( entity.getCreationDate() );
        seansDTO.setSeansName( entity.getSeansName() );
        seansDTO.setSeansDate( entity.getSeansDate() );

        return seansDTO;
    }

    @Override
    public Set<Seans> toEntitySet(Set<SeansDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Seans> set = new HashSet<Seans>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( SeansDTO seansDTO : dtoSet ) {
            set.add( toEntity( seansDTO ) );
        }

        return set;
    }

    @Override
    public Set<SeansDTO> toDTOSet(Set<Seans> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<SeansDTO> set = new HashSet<SeansDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Seans seans : entitySet ) {
            set.add( toDTO( seans ) );
        }

        return set;
    }
}
