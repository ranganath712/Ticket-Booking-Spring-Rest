package com.tbs.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tbs.entity.Ticket;
import com.tbs.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/new")
	public ResponseEntity<String> bookATicket(@RequestBody Ticket ticket){
		String bookATicket = ticketService.bookATicket(ticket);
		return new ResponseEntity<>(bookATicket,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Integer id){
		Ticket ticketById = ticketService.getTicketById(id);
		return new ResponseEntity<>(ticketById,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam(name = "length", required = false) Long length){
		List<Ticket> allTickets = ticketService.getAllTickets(length);
		if(length == null) {
			return new ResponseEntity<>(allTickets.stream().limit(allTickets.size()).collect(Collectors.toList()),HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(allTickets.stream().limit(length).collect(Collectors.toList()),HttpStatus.OK);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathVariable Integer id){
		Ticket updateTicket = ticketService.updateTicket(ticket, id);
		return new ResponseEntity<>(updateTicket,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteATicket(@PathVariable Integer id){
		boolean deleteTicket = ticketService.deleteTicket(id);
		String status = "";
		if(deleteTicket) {
			status = "Deleted the ticket successfully";
		}
		return new ResponseEntity<>(status,HttpStatus.ACCEPTED);
	}

}
