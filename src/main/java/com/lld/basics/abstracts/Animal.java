package com.lld.basics.abstracts;

public abstract class Animal {
    public String name;
    public int age;

    public abstract void walk();

    public int numberOfLegs() {
        return 0;
    }
}
