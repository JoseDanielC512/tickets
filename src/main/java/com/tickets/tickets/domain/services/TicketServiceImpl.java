package com.tickets.tickets.domain.services;

import com.tickets.tickets.domain.model.Ticket;
import com.tickets.tickets.domain.ports.input.TicketUseCase;
import com.tickets.tickets.domain.ports.output.TicketRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class TicketServiceImpl implements TicketUseCase {

    private final TicketRepositoryPort ticketRepository;

    public TicketServiceImpl(TicketRepositoryPort ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket crearTicket(Ticket ticket) {
        Objects.requireNonNull(ticket, "El ticket no puede ser nulo");
        Objects.requireNonNull(ticket.getUsuario(), "El usuario es obligatorio");
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setFechaActualizacion(LocalDateTime.now());

        if (ticket.getStatus() == null) {
            ticket.setStatus(Ticket.Status.OPEN);
        }

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket editarTicket(Long id, Ticket ticketActualizado) {
        Ticket ticketExistente = obtenerTicketPorId(id);
        ticketExistente.setUsuario(ticketActualizado.getUsuario());
        ticketExistente.setStatus(ticketActualizado.getStatus());
        ticketExistente.setFechaActualizacion(LocalDateTime.now());
        return ticketRepository.edit(id, ticketExistente);
    }

    @Override
    public void eliminarTicket(Long id) {
        obtenerTicketPorId(id);
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket obtenerTicketPorId(Long id) {
        Ticket ticket = ticketRepository.findById(id);

        if (ticket == null) {
            throw new RuntimeException("Ticket no encontrado con ID: " + id);
        }

        return ticket;
    }

    @Override
    public Page<Ticket> obtenerTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }
}