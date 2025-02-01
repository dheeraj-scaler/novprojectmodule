package com.lld.basics.overriding;

public class Client {

    public static void main(String[] args) {
//        A a = new A();
//        a.doSome(); // Parent



//        B x = new B();
//        x.doSome(); // Child one
//        x.parentCannotAccessThis();

//        A a = new B();
//        a.doSome();

        B b = new B();
        b.doSome(1);
        b.doSome(1);


//        Do we know the exact doSome function
//        that is about to run in compile time?
//        No, and that's why it's called RunTime polymorphism

        // In case of method overriding,
        // runtime relies on actual object
    }
}
