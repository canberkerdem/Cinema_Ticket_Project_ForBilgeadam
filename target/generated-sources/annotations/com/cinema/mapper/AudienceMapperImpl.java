package com.cinema.mapper;

import com.cinema.dto.AudienceDTO;
import com.cinema.entity.Audience;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T02:48:57+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
@Component
public class AudienceMapperImpl implements AudienceMapper {

    @Override
    public Audience toEntity(AudienceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Audience audience = new Audience();

        audience.setId( dto.getId() );
        audience.setAudienceName( dto.getAudienceName() );
        audience.setAudienceSurname( dto.getAudienceSurname() );
        audience.setAge( dto.getAge() );

        return audience;
    }

    @Override
    public AudienceDTO toDTO(Audience entity) {
        if ( entity == null ) {
            return null;
        }

        AudienceDTO audienceDTO = new AudienceDTO();

        audienceDTO.setId( entity.getId() );
        audienceDTO.setCreationDate( entity.getCreationDate() );
        audienceDTO.setAudienceName( entity.getAudienceName() );
        audienceDTO.setAudienceSurname( entity.getAudienceSurname() );
        audienceDTO.setAge( entity.getAge() );

        return audienceDTO;
    }

    @Override
    public Set<Audience> toEntitySet(Set<AudienceDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Audience> set = new HashSet<Audience>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( AudienceDTO audienceDTO : dtoSet ) {
            set.add( toEntity( audienceDTO ) );
        }

        return set;
    }

    @Override
    public Set<AudienceDTO> toDTOSet(Set<Audience> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<AudienceDTO> set = new HashSet<AudienceDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Audience audience : entitySet ) {
            set.add( toDTO( audience ) );
        }

        return set;
    }
}
