package com.parkinglot.strategies;

import com.parkinglot.models.ParkingSpot;
import com.parkinglot.models.VehicleType;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Long gateId) {
        return null;
        // iterate though all the spots and if something is empty, simple return it
    }
}
