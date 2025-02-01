package com.lld.basics.am1;

public class Student {
    private String name; // Private
    int batchId;         // Default
    protected double psp; // Protected
    public String uniName; // Public


    public void doSomething() {
        System.out.println(this.name);
        System.out.println(this.batchId);
        System.out.println(this.psp);
        System.out.println(this.uniName);

    }
//    protected void doSomething() {
//        System.out.println(this.name);
//        System.out.println(this.batchId);
//        System.out.println(this.psp);
//        System.out.println(this.uniName);
//    }
    // By default is we have not defined any constructor
    // java comes up with default constructors.
}