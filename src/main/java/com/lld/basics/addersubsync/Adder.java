package com.lld.basics.addersubsync;

public class Adder implements Runnable {
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i=0; i<100000; i++) {
            synchronized (count) { // Internally it is calling lock.lock() on object count
                count.value += 1;
            }// unlocking it
        }
    }
}
