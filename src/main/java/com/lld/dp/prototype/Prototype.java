package com.lld.dp.prototype;

// To make the prototype interface generic
// To ensure every class implements the clone method
public interface Prototype<T>{
    T clone();
    // T is the return type
    // clone is the name of the method
}
