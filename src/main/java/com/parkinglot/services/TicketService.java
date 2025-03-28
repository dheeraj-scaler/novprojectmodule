package com.parkinglot.services;

import com.parkinglot.factory.SpotAssignmentStrategyFactory;
import com.parkinglot.models.*;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingSpotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.strategies.SpotAssignmentStrategy;

import java.util.Optional;

public class TicketService {


    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(GateRepository gateRepository, TicketRepository ticketRepository, VehicleRepository vehicleRepository, ParkingSpotRepository parkingSpotRepository) {
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber,
                              String ownerName, VehicleType vehicleType, SpotAssignmentStrategyType type) {

       Ticket ticket = new Ticket();
       // 1. get gate information from gateRepo
        // 2. vehicle Repo
        // 3. parking Spot Repo
        // 4. Save ticket using Ticket Repo

        Optional<Gate> gate = gateRepository.findGateById(gateId);
        if(gate.isEmpty()) {
            // throw some error here
        }
//        if(gate.get().getGateStatus().equals(GateStatus.CLOSED)) {
//            // throw a different error
//        }
        //ticket.setGate(gate.get());

        // Implement get vehicle in repository
//        Optional<Vehicle> savedVehicle = vehicleRepository.getVehicle()
        // If the vehicle is empty, then save the vehicle in db

        // Using some strategy, assign the parking spot
        SpotAssignmentStrategy spotStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(type);
        ParkingSpot ps = spotStrategy.assignSpot(vehicleType, gateId);
        ticket.setParkingSpot(ps);

        // Save the ticket in db
        ticketRepository.save(ticket);

       return ticket;
    }
}
