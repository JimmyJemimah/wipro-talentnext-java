package comm.automobile.twowheeler;

import comm.automobile.Vehicle;

public class Hero extends Vehicle {

    public String getModelName() {
        return "Hero Splendor";
    }

    public String getRegistrationNumber() {
        return "AP39AB1234";
    }

    public String getOwnerName() {
        return "Jimmy";
    }

    public int getSpeed() {
        return 80;
    }

    public void radio() {
        System.out.println("Radio is ON");
    }
}