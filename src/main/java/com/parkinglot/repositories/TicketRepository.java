package com.parkinglot.repositories;

import com.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    // methods around saving a ticket

    private Map<Long, Ticket> ticketsMap = new HashMap<>();
    private Long previousTicketId = 0L;

    public Ticket save(Ticket ticket) {
        if(ticket.getId() == null) {
            // this is a new ticket
            previousTicketId += 1;
            ticket.setId(previousTicketId);
            ticketsMap.put(previousTicketId, ticket);
        }

        return ticket;
    }
}