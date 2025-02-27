package com.lld.dp.singleton;

public class DatabaseConnection {

    // Eager
//    public static DatabaseConnection dbc = new DatabaseConnection();
//
//    private DatabaseConnection(){}
//
//    public static DatabaseConnection getInstance(){
//        return dbc;
//    }


    // Lazy Initialization or double check locking
    private static DatabaseConnection dbc = null;

    // private constructor
    private DatabaseConnection(){

    }

    public static DatabaseConnection getInstance(){
        if(dbc == null) {
            // lock
            synchronized (DatabaseConnection.class) {
                if(dbc == null) {
                    dbc = new DatabaseConnection();
                }
            }
        }
        return dbc;
    }
}
