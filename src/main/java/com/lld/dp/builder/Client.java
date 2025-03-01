package com.lld.dp.builder;

public class Client {

    public static void main(String[] args) {
//         Builder b = new Builder();
//         b.setName("Anmol");
//         b.setAge(18);
//         b.setGradYear(2020);
//         b.setPhoneNumber("7870745678");
//
//         //Student s = new Student(b);
//
//        Student s = b.build();


        Student s = Student.Builder.getBuilder()
                .setName("Dipesh")
                .setAge(19)
                .build();


                // set name and age

    }
}
