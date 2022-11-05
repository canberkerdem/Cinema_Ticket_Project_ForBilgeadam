package com.cinema.mapper;

import com.cinema.dto.TicketDTO;
import com.cinema.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper
public interface TicketMapper extends BaseMapper<Ticket, TicketDTO> {
}
