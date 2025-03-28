package com.parkinglot.strategies;

import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSpot;
import com.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Long gateId);
}
