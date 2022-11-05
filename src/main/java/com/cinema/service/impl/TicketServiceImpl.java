package com.cinema.service.impl;

import com.cinema.dto.AudienceDTO;
import com.cinema.dto.AudienceTicketRequestDTO;
import com.cinema.dto.CancelTicketDTO;
import com.cinema.dto.TicketDTO;
import com.cinema.entity.Audience;
import com.cinema.entity.Movie;
import com.cinema.entity.Seans;
import com.cinema.entity.Ticket;
import com.cinema.exception.CancellationException;
import com.cinema.exception.SeansNotFoundException;
import com.cinema.exception.TicketNotFoundException;
import com.cinema.exception.ViolateAgeRulesException;
import com.cinema.mapper.AudienceMapper;
import com.cinema.mapper.TicketMapper;
import com.cinema.repository.TicketRepository;
import com.cinema.service.SeansService;
import com.cinema.service.TicketService;
import com.cinema.util.TicketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.cinema.util.Consts.*;


@Service
public class TicketServiceImpl implements TicketService {

    private final TicketMapper ticketMapper;

    private final AudienceMapper audienceMapper;

    private final TicketRepository ticketRepository;

    @Autowired
    private final SeansService seansService;

    public TicketServiceImpl(TicketRepository ticketRepository,
                             TicketMapper ticketMapper, AudienceMapper audienceMapper, SeansService seansService) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.audienceMapper = audienceMapper;
        this.seansService = seansService;
    }

    @Override
    public TicketDTO createTicket(AudienceTicketRequestDTO audienceTicketRequestDTO) throws ViolateAgeRulesException, SeansNotFoundException {
        Seans seans = seansService.getById(audienceTicketRequestDTO.getSeansId());

        Movie movie = seans.getMovie();
        validateAudiences(movie, audienceTicketRequestDTO.getAudienceSet());

        Set<Audience> audienceSet = audienceMapper.toEntitySet(audienceTicketRequestDTO.getAudienceSet());

        Ticket ticket = new Ticket();
        ticket.setSeans(seans);
        ticket.setTicketNumber(TicketUtil.createUniqueNumber());
        ticket.setAudienceSet(audienceSet);


        ticket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(ticket);
    }

    @Override
    public String cancelTicket(CancelTicketDTO cancelTicketDTO) throws CancellationException, TicketNotFoundException {
        Ticket ticket = ticketRepository.findByTicketNumber(cancelTicketDTO.getTicketNumber())
                .orElseThrow(
                        () -> new TicketNotFoundException(NO_TICKET_FOUND)
                );
        boolean surnameChecking = checkSurname(ticket, cancelTicketDTO.getSurname());

        if (!surnameChecking) {
            throw new CancellationException(CANCEL_SURNAME_EXCEPTION);
        }

        ticketRepository.delete(ticket);
        return CANCEL_TICKET + cancelTicketDTO.getTicketNumber();
    }

    @Override
    public Set<TicketDTO> findByTicketInDate(LocalDate localDate) throws TicketNotFoundException {
        List<Ticket> ticketList = ticketRepository.findBySeans_SeansDate(localDate).orElseThrow(
                () -> new TicketNotFoundException(NO_TICKET_FOUND)
        );

        return ticketMapper.toDTOSet(new HashSet<>(ticketList));
    }

    @Override
    public TicketDTO findByTicketNumber(String ticketNumber) throws TicketNotFoundException {
        Ticket ticket = ticketRepository.findByTicketNumber(ticketNumber).orElseThrow(
                () -> new TicketNotFoundException(NO_TICKET_FOUND)
        );
        return ticketMapper.toDTO(ticket);
    }

    private void validateAudiences(Movie movieOfTicket, Set<AudienceDTO> audienceDTOSet)
            throws ViolateAgeRulesException {

        int minAge = movieOfTicket.getMinAge();
        int maxAge = movieOfTicket.getMaxAge();

        for (AudienceDTO audienceDTO : audienceDTOSet) {
            int audienceAge = audienceDTO.getAge();
            if (audienceAge < minAge || audienceAge > maxAge) {
                throw new ViolateAgeRulesException(AGE_RULE_EXCEPTION +
                        MIN_AGE + minAge +
                        MAX_AGE + maxAge);
            }
        }
    }

    private boolean checkSurname(Ticket ticket, String givenSurname) throws TicketNotFoundException {

        for (Audience audience : ticket.getAudienceSet()) {
            if (audience.getAudienceSurname().equalsIgnoreCase(givenSurname)) {
                return true;
            }
        }

        return false;
    }
}
