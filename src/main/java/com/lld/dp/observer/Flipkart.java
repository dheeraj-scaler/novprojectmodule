package com.lld.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {
    // Publisher
    // singleton flipkart
    private static Flipkart instance = null;

    private Flipkart(){}

    public static Flipkart getInstance() {
        if (instance == null) {
            instance = new Flipkart();
        }
        return instance;
    }

    private List<OnOrderPlacedSubscriber> onOrderPlacedSubscribers = new ArrayList<>();


    // registering to the list
    void registerSubscriber(OnOrderPlacedSubscriber onOrderPlacedSubscriber) {
        onOrderPlacedSubscribers.add(onOrderPlacedSubscriber);
    }

    // removing from the list
    void unRegisterSubscriber(OnOrderPlacedSubscriber onOrderPlacedSubscriber) {
        onOrderPlacedSubscribers.remove(onOrderPlacedSubscriber);
    }
//
    public void onOrderPlaced() {

        for (OnOrderPlacedSubscriber onOrderPlacedSubscriber : onOrderPlacedSubscribers) {
            onOrderPlacedSubscriber.announceOrderPlaced();
        }
    }
}