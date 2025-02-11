package com.lld.basics.addersubtractor;

public class Adder implements Runnable {
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i += 1) {
            // lock
            count.value += 1;
            // unlock
        }
    }
}