package com.lld.basics.constructorchain;

public class D extends C {
    public int val1;
//    public D() {
//        //super(10);
//        System.out.println("Constructor of D");
//    }

//    public D(int newValue) {
//        this.val = newValue;
//    }

    public D(int val1, int val2) {
        super(val2);
        this.val1 = val1;
        System.out.println("Constructor of D");
    }


}
