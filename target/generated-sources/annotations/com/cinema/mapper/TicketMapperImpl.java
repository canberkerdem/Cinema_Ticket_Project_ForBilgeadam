package com.cinema.mapper;

import com.cinema.dto.AudienceDTO;
import com.cinema.dto.SeansDTO;
import com.cinema.dto.TicketDTO;
import com.cinema.entity.Audience;
import com.cinema.entity.Seans;
import com.cinema.entity.Ticket;
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
public class TicketMapperImpl implements TicketMapper {

    @Override
    public Ticket toEntity(TicketDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setId( dto.getId() );
        ticket.setTicketNumber( dto.getTicketNumber() );
        ticket.setSeans( seansDTOToSeans( dto.getSeans() ) );
        ticket.setAudienceSet( audienceDTOSetToAudienceSet( dto.getAudienceSet() ) );

        return ticket;
    }

    @Override
    public TicketDTO toDTO(Ticket entity) {
        if ( entity == null ) {
            return null;
        }

        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId( entity.getId() );
        ticketDTO.setCreationDate( entity.getCreationDate() );
        ticketDTO.setTicketNumber( entity.getTicketNumber() );
        ticketDTO.setSeans( seansToSeansDTO( entity.getSeans() ) );
        ticketDTO.setAudienceSet( audienceSetToAudienceDTOSet( entity.getAudienceSet() ) );

        return ticketDTO;
    }

    @Override
    public Set<Ticket> toEntitySet(Set<TicketDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Ticket> set = new HashSet<Ticket>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( TicketDTO ticketDTO : dtoSet ) {
            set.add( toEntity( ticketDTO ) );
        }

        return set;
    }

    @Override
    public Set<TicketDTO> toDTOSet(Set<Ticket> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<TicketDTO> set = new HashSet<TicketDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Ticket ticket : entitySet ) {
            set.add( toDTO( ticket ) );
        }

        return set;
    }

    protected Seans seansDTOToSeans(SeansDTO seansDTO) {
        if ( seansDTO == null ) {
            return null;
        }

        Seans seans = new Seans();

        seans.setId( seansDTO.getId() );
        seans.setCreationDate( seansDTO.getCreationDate() );
        seans.setSeansName( seansDTO.getSeansName() );
        seans.setSeansDate( seansDTO.getSeansDate() );

        return seans;
    }

    protected Audience audienceDTOToAudience(AudienceDTO audienceDTO) {
        if ( audienceDTO == null ) {
            return null;
        }

        Audience audience = new Audience();

        audience.setId( audienceDTO.getId() );
        audience.setCreationDate( audienceDTO.getCreationDate() );
        audience.setAudienceName( audienceDTO.getAudienceName() );
        audience.setAudienceSurname( audienceDTO.getAudienceSurname() );
        audience.setAge( audienceDTO.getAge() );

        return audience;
    }

    protected Set<Audience> audienceDTOSetToAudienceSet(Set<AudienceDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Audience> set1 = new HashSet<Audience>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AudienceDTO audienceDTO : set ) {
            set1.add( audienceDTOToAudience( audienceDTO ) );
        }

        return set1;
    }

    protected SeansDTO seansToSeansDTO(Seans seans) {
        if ( seans == null ) {
            return null;
        }

        SeansDTO seansDTO = new SeansDTO();

        seansDTO.setId( seans.getId() );
        seansDTO.setCreationDate( seans.getCreationDate() );
        seansDTO.setSeansName( seans.getSeansName() );
        seansDTO.setSeansDate( seans.getSeansDate() );

        return seansDTO;
    }

    protected AudienceDTO audienceToAudienceDTO(Audience audience) {
        if ( audience == null ) {
            return null;
        }

        AudienceDTO audienceDTO = new AudienceDTO();

        audienceDTO.setId( audience.getId() );
        audienceDTO.setCreationDate( audience.getCreationDate() );
        audienceDTO.setAudienceName( audience.getAudienceName() );
        audienceDTO.setAudienceSurname( audience.getAudienceSurname() );
        audienceDTO.setAge( audience.getAge() );

        return audienceDTO;
    }

    protected Set<AudienceDTO> audienceSetToAudienceDTOSet(Set<Audience> set) {
        if ( set == null ) {
            return null;
        }

        Set<AudienceDTO> set1 = new HashSet<AudienceDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Audience audience : set ) {
            set1.add( audienceToAudienceDTO( audience ) );
        }

        return set1;
    }
}
