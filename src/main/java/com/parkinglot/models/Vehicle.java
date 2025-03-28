package com.parkinglot.models;

public class Vehicle  extends BaseModel {
    private String number;
    private String vehicleOwner;
    private VehicleType vehicleType;
    // every class you can add more attributes


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
