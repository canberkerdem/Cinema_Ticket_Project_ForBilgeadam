package com.cinema.service;

import com.cinema.dto.AudienceTicketRequestDTO;
import com.cinema.dto.CancelTicketDTO;
import com.cinema.dto.TicketDTO;
import com.cinema.exception.SeansNotFoundException;
import com.cinema.exception.TicketNotFoundException;
import com.cinema.exception.ViolateAgeRulesException;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.CancellationException;

public interface TicketService {

    TicketDTO createTicket(AudienceTicketRequestDTO audienceTicketRequestDTO) throws ViolateAgeRulesException, SeansNotFoundException;

    String cancelTicket(CancelTicketDTO cancelTicketDTO) throws CancellationException, TicketNotFoundException, com.cinema.exception.CancellationException;

    Set<TicketDTO> findByTicketInDate(LocalDate localDate) throws TicketNotFoundException;

    TicketDTO findByTicketNumber(String TicketNumber) throws TicketNotFoundException;
}
