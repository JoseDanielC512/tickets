package com.tickets.tickets.infrastructure.repositories;

import com.tickets.tickets.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketJpaRepository extends JpaRepository<Ticket, Long> {

}
