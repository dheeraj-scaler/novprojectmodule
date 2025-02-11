package com.lld.basics.producerconsumer;

import java.util.Queue;

public class Producer implements Runnable {

    private Queue< Object > queue;

    private int maxsize;




    public Producer (Queue<Object> queue, int maxsize) {
        this.queue = queue;
        this.maxsize = maxsize;
    }




    @Override
    public void run() {
        while (true) { // P1 and P2
            // (1)
            // lock
            synchronized (queue) { // lock
                if (queue.size() < maxsize) { // P1 & P2
                    queue.add((new Object()));
                    System.out.println(queue.size());
                }
            } // unlock
            // unlock
        }
    }
}