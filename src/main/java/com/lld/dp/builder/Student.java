package com.lld.dp.builder;

public class Student {

    String name;
    int age;
    String batch;
    double psp;
    int gradYear;
    String phoneNumber;
    String email;

    public Student(Builder builder) {
        if(builder.getGradYear() >= 2022) {
            throw new RuntimeException("Grad year should be less than 2022");
        }


        // do all the validations here

        this.name = builder.getName();
        this.age = builder.getAge();
        this.batch = builder.getBatch();
        this.psp = builder.getPsp();
        this.gradYear = builder.getGradYear();
        this.phoneNumber = builder.getPhoneNumber();
    }
}
