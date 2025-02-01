package com.lld.basics.constructorchain;

public class C extends B{
    private int val;
    public String nameOfCollege;
    public C(int val2) {
        this.val = val2;
        System.out.println("Constructor of C params");
    }

    public C() {

    }

//    public C() {
//        System.out.println("Constructor of C");
//    }
}
