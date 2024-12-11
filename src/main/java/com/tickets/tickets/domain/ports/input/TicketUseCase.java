package com.tickets.tickets.domain.ports.input;

import com.tickets.tickets.domain.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketUseCase {

    Ticket crearTicket(Ticket ticket);

    Ticket editarTicket(Long id, Ticket ticket);

    void eliminarTicket(Long id);

    Ticket obtenerTicketPorId(Long id);

    Page<Ticket> obtenerTickets(Pageable pageable);
}
