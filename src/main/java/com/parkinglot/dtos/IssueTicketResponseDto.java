package com.parkinglot.dtos;

import com.parkinglot.models.Ticket;

public class IssueTicketResponseDto {
    private Ticket ticket; // subset of attributes in the ticket
    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
