package com.lld.basics.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private Queue<Object> queue;

    private int maxsize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    public Consumer (Queue<Object> queue, int maxsize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxsize = maxsize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }






    @Override
    public void run() {
        while(true) {
            // acquire consumer
            // remove
            // release producer






            try {
                consumerSemaphore.acquire();
            }
            catch (InterruptedException e) {
                throw new RuntimeException (e);
            }
            if (!queue.isEmpty()) {
                System.out.println("Consumer "+ Thread.currentThread().getName());
                queue.remove();
                System.out.println(queue.size());

            }
            producerSemaphore.release();
        }
    }
}