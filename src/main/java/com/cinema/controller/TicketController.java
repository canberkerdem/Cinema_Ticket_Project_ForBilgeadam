package com.cinema.controller;

import com.cinema.dto.AudienceTicketRequestDTO;
import com.cinema.dto.CancelTicketDTO;
import com.cinema.dto.TicketDTO;
import com.cinema.exception.CancellationException;
import com.cinema.exception.SeansNotFoundException;
import com.cinema.exception.TicketNotFoundException;
import com.cinema.exception.ViolateAgeRulesException;
import com.cinema.service.TicketService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Set;

import static com.cinema.util.Consts.*;

@RestController
@RequestMapping("/ticket")
@Slf4j
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "ticket for seans",
            notes = "make a ticket via json request.",
            responseContainer = "ticket for seans",
            response = ResponseEntity.class)
    @PostMapping("/create")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = AGE_RULE_EXCEPTION),
            @ApiResponse(code = 404, message = NO_SEANS_FOUND)
    })
    public TicketDTO createTicket(@Valid @RequestBody AudienceTicketRequestDTO audienceTicketRequestDTO)
            throws ViolateAgeRulesException, SeansNotFoundException {
        return ticketService.createTicket(audienceTicketRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "cancellation ticket with ticketNumber and surname",
            notes = "Surname matching is mandatory for canceling. The given surname must be one of the audiences' surname.",
            responseContainer = "cancel a ticket",
            response = ResponseEntity.class)
    @PostMapping("/cancel")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = CANCEL_SURNAME_EXCEPTION),
            @ApiResponse(code = 404, message = NO_TICKET_FOUND)
    })
    public String cancelTicket(@Valid @RequestBody CancelTicketDTO cancelTicketDTO) throws CancellationException, TicketNotFoundException {
        return ticketService.cancelTicket(cancelTicketDTO);
    }
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "view ticket in a date for seans",
            notes = "view tickets for a specific date.",
            responseContainer = "view tickets in a date",
            response = ResponseEntity.class)
    @GetMapping("/view_tickets_with_date")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = NO_TICKET_FOUND)
    })
    public Set<TicketDTO> viewTicketWithDate(@RequestParam("localDate") @Valid
                                               @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate localDate) throws TicketNotFoundException {
        return ticketService.findByTicketInDate(localDate);
    }
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "viewing a ticket for seans",
            notes = "view a ticket via ticketNumber.",
            responseContainer = "view ticket for seans",
            response = ResponseEntity.class)
    @GetMapping("/view_ticket")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = NO_TICKET_FOUND)
    })
    public TicketDTO viewTicket(@RequestParam String ticketNumber) throws TicketNotFoundException {
        return ticketService.findByTicketNumber(ticketNumber);
    }

}




