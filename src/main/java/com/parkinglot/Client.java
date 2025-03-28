package com.parkinglot;

import com.parkinglot.controllers.TicketController;
import com.parkinglot.dtos.IssueTicketRequestDto;
import com.parkinglot.dtos.IssueTicketResponseDto;
import com.parkinglot.models.VehicleType;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingSpotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.services.TicketService;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        // Crete a ticket
        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setVehicleOwnerName("Shoeb");
        requestDto.setEntryTime(new Date());
        requestDto.setVehicleNumber("ABCD");
        requestDto.setGateId(12L);
        requestDto.setVehicleType(VehicleType.SEDAN);

        GateRepository gateRepository  = new GateRepository();;
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository,ticketRepository, vehicleRepository, parkingSpotRepository);
        TicketController ticketController = new TicketController(ticketService);

        // Issue a ticket using the controller

        IssueTicketResponseDto ticket = ticketController.issueTicket(requestDto);
        System.out.println(ticket.getTicket().getId());


        IssueTicketResponseDto ticket1 = ticketController.issueTicket(requestDto);
        System.out.println(ticket1.getTicket().getId());


    }
}
