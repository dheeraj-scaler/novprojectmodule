package com.lld.basics.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private Queue<Object> queue;

    private int maxsize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;



    public Producer (Queue<Object> queue, int maxsize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxsize = maxsize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }




    @Override
    public void run() {
        while (true) {
            // acquire producerSemaphore
            // add to the queue
            // release consumerSemaphore


            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (queue.size() < maxsize) {
                System.out.println("Producer "+ Thread.currentThread().getName());
                queue.add((new Object()));
                System.out.println(queue.size());
            }
            consumerSemaphore.release();
        }
    }
}
