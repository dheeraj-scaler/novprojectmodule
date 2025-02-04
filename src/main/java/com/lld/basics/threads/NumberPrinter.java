package com.lld.basics.threads;

//public class NumberPrinter implements Runnable{
//    private int numberToPrint;
//    NumberPrinter(int numberToPrint){
//        this.numberToPrint = numberToPrint;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Printing" + this.numberToPrint + ". Printed by Thread" + Thread.currentThread().getName());
//    }
//}

// SOP
// 1. think the task that can be done in parallel
// 2. Create a class for the task
// 3. Implement runnable interface
public class NumberPrinter implements Runnable {

    private int currNumber;

    public NumberPrinter(int currNumber) {
        this.currNumber = currNumber;
    }

    @Override
    public void run() {
        System.out.println("We are printing" + this.currNumber + " The thread executing this function is " + Thread.currentThread().getName());
    }

}
