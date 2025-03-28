package com.parkinglot.factory;

import com.parkinglot.models.SpotAssignmentStrategyType;
import com.parkinglot.strategies.CheapestSportAssignmentStrategy;
import com.parkinglot.strategies.RandomSpotAssignmentStrategy;
import com.parkinglot.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType type) {
        if(type.equals(SpotAssignmentStrategyType.CHEAP)) {
            return new CheapestSportAssignmentStrategy();
        } else {
            return new RandomSpotAssignmentStrategy();
        }
    }
}
