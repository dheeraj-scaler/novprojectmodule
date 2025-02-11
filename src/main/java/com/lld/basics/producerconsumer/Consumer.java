package com.lld.basics.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue< Object > queue;

    private int maxsize;
    public Consumer (Queue < Object > queue, int maxsize) {
        this.queue = queue;
        this.maxsize = maxsize;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    queue.remove();
                    System.out.println(queue.size());
                }
            }
        }
    }
}