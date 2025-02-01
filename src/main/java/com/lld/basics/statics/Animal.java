package com.lld.basics.statics;

public class Animal {

    public static int variable = 5; // class attribute
    public int notStatic = 2; // object attr
    public static String printSomething() {
        System.out.println("We are in animal");
        System.out.println(variable);
//        System.out.println(notStatic);
        return "Hello";
    }
}
