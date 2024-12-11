package com.tickets.tickets.domain.ports.output;

import com.tickets.tickets.domain.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketRepositoryPort {

    Ticket save(Ticket ticket);

    Ticket edit(Long id, Ticket ticket);

    void deleteById(Long id);

    Ticket findById(Long id);

    Page<Ticket> findAll(Pageable pageable);
}
