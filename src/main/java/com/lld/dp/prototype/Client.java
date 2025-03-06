package com.lld.dp.prototype;

public class Client {

    public static void setValues(StudentRegistry studentRegistry) {
        Student july = new Student();
        july.setBatch("July 23 Beginner");
        july.setAvgPsp(50.0);
        july.setInstructorName("Dheeraj");
        // storing in the map
        studentRegistry.register("stu", july);

        IntelligentStudent july24 = new IntelligentStudent();
        july24.setIq(180);
        july24.setBatch("July 24 Beginner");
        july24.setAvgPsp(80.0);
        july24.setInstructorName("Dheeraj");
        studentRegistry.register("intStu", july24);


    }


    public static void main(String[] args) {
        StudentRegistry register = new StudentRegistry();
        setValues(register);


        // Without using registery
//        Student stu = new Student();
//        stu.setBatch("July 23 Beginner");
//        stu.setAvgPsp(50.0);
//        stu.setInstructorName("Dheeraj");
//
//        IntelligentStudent intStu = new IntelligentStudent();
//        intStu.setIq(180);
//        intStu.setBatch("July 24 Beginner");
//        intStu.setAvgPsp(80.0);
//        intStu.setInstructorName("Satwik");


        //-------------- Using registry--------
        Student aditya = register.get("intStu").clone();

        Student dheeraj = register.get("stu").clone();


//        Student sujit = register.get("july").clone();
//        sujit.setName("Sujit");
//        sujit.setAge(25);
//        sujit.setCity("Bangalore");
//
//
//        Student is = register.get("july24").clone();
//        is.setName("Jyoti");
//        is.setCity("Kota");

        System.out.println("Debug here");
    }
}
