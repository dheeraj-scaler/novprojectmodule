package com.lld.dp.builder;

public class Student {

    String name;
    int age;
    String batch;
    double psp;
    int gradYear;
    String phoneNumber;
    String email;

    // make this private
    private Student(Builder builder) {


        this.name = builder.getName();
        this.age = builder.getAge();
        this.batch = builder.getBatch();
        this.psp = builder.getPsp();
        this.gradYear = builder.getGradYear();
        this.phoneNumber = builder.getPhoneNumber();
    }



    public static class Builder {

        String name;
        int age;
        String batch;
        double psp;
        int gradYear;
        String phoneNumber;
        String email;

        public String getName() {
            return name;
        }

        // return type as Builder in order to support chain while setting the values
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        // responsible for validations and calling student cons
        public Student build() {
            // cons of student with the attr of builder
            if(this.getGradYear() >= 2022) {
                throw new RuntimeException("Grad year should be less than 2022");
            }


            // do all the validations here

            return new Student(this);
        }

        public static Builder getBuilder() {
            return new Builder();
        }
    }
}
