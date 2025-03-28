package com.parkinglot.controllers;

import com.parkinglot.dtos.IssueTicketRequestDto;
import com.parkinglot.dtos.IssueTicketResponseDto;
import com.parkinglot.dtos.ResponseStatus;
import com.parkinglot.models.SpotAssignmentStrategyType;
import com.parkinglot.models.Ticket;
import com.parkinglot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) {
       Ticket ticket = ticketService.issueTicket(requestDto.getGateId(),
               requestDto.getVehicleNumber(),
               requestDto.getVehicleOwnerName(),
               requestDto.getVehicleType(), SpotAssignmentStrategyType.CHEAP);

       IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
       responseDto.setTicket(ticket);
       responseDto.setResponseStatus(ResponseStatus.SUCCESS);
       return responseDto;
    }
}
