package com.lld.basics.threads;

public class Client {

    public static void main(String[] args) {
//        System.out.println("We are here " + Thread.currentThread().getName());

        long start = System.currentTimeMillis();
        for(int i=0; i<10000000; i++) {
//            NumberPrinter num = new NumberPrinter(i);
//            Thread t = new Thread(num);
//            t.start();
//            System.out.println(i);

            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread t = new Thread(numberPrinter);
            t.start(); // runs it for us
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);


//        System.out.println("Name of the thread running " + Thread.currentThread().getName());
    }
}

//1738689542450 -> 1738689542549

//1738689583607 -> 1738689585479
