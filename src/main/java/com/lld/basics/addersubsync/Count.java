package com.lld.basics.addersubsync;

public class Count {
    public int value=0;

    public synchronized void increment() {
        value += 1;
    }

    public synchronized void decrement() {
        value -= 1;
    }
}
