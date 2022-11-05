package com.cinema.repository;

import com.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Optional<List<Ticket>> findBySeans_SeansDate(LocalDate seans_seansDate);

    Optional<Ticket> findByTicketNumber(String ticketNumber);
}
