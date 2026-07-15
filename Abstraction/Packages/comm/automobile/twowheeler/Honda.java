package comm.automobile.twowheeler;

import comm.automobile.Vehicle;

public class Honda extends Vehicle {

    public String getModelName() {
        return "Honda Shine";
    }

    public String getRegistrationNumber() {
        return "AP39CD5678";
    }

    public String getOwnerName() {
        return "Jimmy";
    }

    public int getSpeed() {
        return 90;
    }

    public void cdplayer() {
        System.out.println("CD Player is ON");
    }
}