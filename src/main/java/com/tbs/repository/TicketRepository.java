package com.tbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbs.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
