package com.lld.basics.constructorchain;

public class Client {

    public static void main(String[] args) {
        D d = new D(1,2);
//        System.out.println(d.val);
        System.out.println(d.nameOfCollege);
        System.out.println(d.age);



//        A a = new B();
//        a.doSome();
//        a.company = "ABC";
//        a.age = 21;
    }
}
