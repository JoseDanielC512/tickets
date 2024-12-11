package com.tickets.tickets.infrastructure.controllers;

import com.tickets.tickets.domain.model.Ticket;
import com.tickets.tickets.domain.ports.input.TicketUseCase;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickets")
public class TicketController {

    private final TicketUseCase ticketUseCase;

    public TicketController(TicketUseCase ticketUseCase) {
        this.ticketUseCase = ticketUseCase;
    }

    @PostMapping
    public ResponseEntity<Ticket> crearTicket(@Valid @RequestBody Ticket ticket) {
        Ticket nuevoTicket = ticketUseCase.crearTicket(ticket);
        return ResponseEntity.ok(nuevoTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> editarTicket(@PathVariable Long id, @Valid @RequestBody Ticket ticket) {
        Ticket ticketActualizado = ticketUseCase.editarTicket(id, ticket);
        return ResponseEntity.ok(ticketActualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerTicket(@PathVariable Long id) {
        Ticket ticket = ticketUseCase.obtenerTicketPorId(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping
    public ResponseEntity<Page<Ticket>> listarTickets(Pageable pageable) {
        Page<Ticket> tickets = ticketUseCase.obtenerTickets(pageable);
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        ticketUseCase.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("Ok");
    }

}
