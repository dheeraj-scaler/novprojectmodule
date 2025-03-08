package com.lld.dp.strategy;

public class GoogleMaps {

    PathCalculatorStrategy pathCalculatorStrategy;

    public void findPath(String from, String to, String mode) {
        // Basis the mode
        // we have to get the correct pathCalculatorStrategy
        pathCalculatorStrategy = PathCalculatorFactory.getPathCalculatorForMode(mode);

        pathCalculatorStrategy.findPath(from, to);
    }
}