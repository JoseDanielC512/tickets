package com.tickets.tickets.infrastructure.repositories;

import com.tickets.tickets.domain.model.Ticket;
import com.tickets.tickets.domain.ports.output.TicketRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TicketRepositoryPortImpl implements TicketRepositoryPort {

    private final TicketJpaRepository ticketJpaRepository;

    public TicketRepositoryPortImpl(TicketJpaRepository ticketJpaRepository) {
        this.ticketJpaRepository = ticketJpaRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketJpaRepository.save(ticket);
    }

    @Override
    public Ticket edit(Long id, Ticket ticket) {
        Optional<Ticket> existingTicket = ticketJpaRepository.findById(id);
        if (existingTicket.isPresent()) {
            ticket.setId(id); // Asegura que el ID no cambia
            return ticketJpaRepository.save(ticket);
        }
        return ticket;
    }

    @Override
    public void deleteById(Long id) {
        ticketJpaRepository.deleteById(id);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketJpaRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return ticketJpaRepository.findAll(pageable);
    }

}