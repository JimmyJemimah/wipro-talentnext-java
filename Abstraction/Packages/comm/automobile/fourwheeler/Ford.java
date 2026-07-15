package com.automobile.fourwheeler;

import comm.automobile.Vehicle;

public class Ford extends Vehicle {

    public String getModelName() {
        return "Ford EcoSport";
    }

    public String getRegistrationNumber() {
        return "TS09GH5678";
    }

    public String getOwnerName() {
        return "Jimmy";
    }

    public int speed() {
        return 140;
    }

    public void tempControl() {
        System.out.println("Air Conditioner Started");
    }
}