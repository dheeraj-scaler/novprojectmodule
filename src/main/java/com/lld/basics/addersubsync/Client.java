package com.lld.basics.addersubsync;

public class Client {
    public static void main(String[] args) throws InterruptedException {
//        Count count = new Count();
//
//        Adder adder = new Adder(count);
//        Subtractor subtractor = new Subtractor(count);
//
//        Thread t1 = new Thread (adder);
//        Thread t2 = new Thread (subtractor);
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        System.out.println(count.value);


        Count c1 = new Count(); // has its own lock
        c1.value = 10;
        Count c2 = new Count(); // has its own implicit lock
    }


}
