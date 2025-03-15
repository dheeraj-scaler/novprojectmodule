package com.lld.dp.observer;

public interface OnOrderPlacedSubscriber {
    // this method will be implemented by all the subscribers
    void announceOrderPlaced();
}