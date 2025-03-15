package com.lld.dp.observer;

public class EmailService implements OnOrderPlacedSubscriber {

    EmailService() {
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }

    void deregister() {
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.unRegisterSubscriber(this);
    }
    @Override
    public void announceOrderPlaced() {
        System.out.println("Sending Email");
    }
}