package com.lld.dp.strategy;

public class PathCalculatorFactory {
    // HW add enum to this
    public static PathCalculatorStrategy getPathCalculatorForMode(String mode) {
        if (mode.equals("Car")) {
            return new CarPathCalculator();
        }
        else if (mode.equals("Bike")) {
            return new BikePathCalculator();
        } else {
            return new WalkPathCalculator();
        }
    }
}