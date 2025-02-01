package com.lld.basics.inheritance;

public class Instructor extends User{
    public String batchName;
    public double averageRating;
    public void scheduleClass() {
        this.username = "";
        System.out.println("Scheduling a class");
    }
    // THis class can have specific attrs and methods
    // related to instructor
}