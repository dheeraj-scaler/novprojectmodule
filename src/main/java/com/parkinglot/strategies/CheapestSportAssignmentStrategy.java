package com.parkinglot.strategies;

import com.parkinglot.models.ParkingSpot;
import com.parkinglot.models.VehicleType;

public class CheapestSportAssignmentStrategy implements SpotAssignmentStrategy{

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Long gateId) {
        return null;
    }
}
