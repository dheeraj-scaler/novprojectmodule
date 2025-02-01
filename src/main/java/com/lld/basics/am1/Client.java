package com.lld.basics.am1;

public class Client {
    public static void main(String[] args) {
        Student st = new Student();
        st.uniName = "U1";
        st.psp = 1.0;
        st.batchId = 1;

        st.doSomething();


        Student st1 = new StudentChild();
        st1.uniName = "U2";
        st1.psp = 2.0;
        st1.batchId = 2;

        // st1 is performing action doSomething
        st1.doSomething();
    }
}