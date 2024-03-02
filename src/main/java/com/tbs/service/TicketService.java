package com.tbs.service;

import java.util.List;

import com.tbs.entity.Ticket;

public interface TicketService {
	
	String bookATicket(Ticket ticket);
	Ticket getTicketById(Integer id);
	List<Ticket> getAllTickets(Long length);
	Ticket updateTicket(Ticket ticket,Integer id);
	boolean deleteTicket(Integer id);
	

}
