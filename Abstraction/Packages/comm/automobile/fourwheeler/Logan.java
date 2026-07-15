package comm.automobile.fourwheeler;

import comm.automobile.Vehicle;

public class Logan extends Vehicle {

    public String getModelName() {
        return "Renault Logan";
    }

    public String getRegistrationNumber() {
        return "TS09EF1234";
    }

    public String getOwnerName() {
        return "Jimmy";
    }

    public int speed() {
        return 120;
    }

    public void gps() {
        System.out.println("GPS Started");
    }
}