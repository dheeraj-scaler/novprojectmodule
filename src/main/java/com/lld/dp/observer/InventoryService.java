package com.lld.dp.observer;

public class InventoryService implements OnOrderPlacedSubscriber {
    InventoryService() {
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }

    @Override
    public void announceOrderPlaced() {
        System.out.println("Notifying Inventory");
    }
}