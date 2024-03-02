package com.tbs.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.entity.Ticket;
import com.tbs.exception.TicketException;
import com.tbs.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public String bookATicket(Ticket ticket) {
		Ticket saveTicket = ticketRepository.save(ticket);
		if (saveTicket.getId()!=null) {
			return "Ticket is successfully booked";
		}else {
			return "Booking failed";
		}
	}

	@Override
	public Ticket getTicketById(Integer id) {
		return ticketRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Please check the id again"));
	}

	@Override
	public List<Ticket> getAllTickets(Long length) {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket updateTicket(Ticket ticket, Integer id) {
		Ticket ticketUpdate = ticketRepository.findById(id).get();
		ticketUpdate.setName(ticket.getName());
		ticketUpdate.setPhoneNo(ticket.getPhoneNo());
		ticketUpdate.setSource(ticket.getSource());
		ticketUpdate.setDestination(ticket.getDestination());
		ticketUpdate.setFare(ticket.getFare());
		return ticketRepository.save(ticketUpdate);
	}

	@Override
	public boolean deleteTicket(Integer id) {
		boolean status = false;
		Ticket deleteTicket = ticketRepository.findById(id).orElseThrow(()-> new TicketException("cannot find the id: "+id+" to delete."));
		
		if(deleteTicket != null) {
			ticketRepository.deleteById(id);
			status = true;
		}
		return status;
	}
	
	

}
