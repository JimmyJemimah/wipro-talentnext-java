package comm.automobile;

import comm.automobile.twowheeler.*;
import comm.automobile.fourwheeler.*;

public class TestVehicle {

    public static void main(String[] args) {

        Hero hero = new Hero();
        Honda honda = new Honda();
        Logan logan = new Logan();
        Ford ford = new Ford();

        System.out.println("----- Hero -----");
        System.out.println(hero.getModelName());
        System.out.println(hero.getRegistrationNumber());
        System.out.println(hero.getOwnerName());
        System.out.println(hero.getSpeed());
        hero.radio();

        System.out.println();

        System.out.println("----- Honda -----");
        System.out.println(honda.getModelName());
        System.out.println(honda.getRegistrationNumber());
        System.out.println(honda.getOwnerName());
        System.out.println(honda.getSpeed());
        honda.cdplayer();

        System.out.println();

        System.out.println("----- Logan -----");
        System.out.println(logan.getModelName());
        System.out.println(logan.getRegistrationNumber());
        System.out.println(logan.getOwnerName());
        System.out.println(logan.speed());
        logan.gps();

        System.out.println();

        System.out.println("----- Ford -----");
        System.out.println(ford.getModelName());
        System.out.println(ford.getRegistrationNumber());
        System.out.println(ford.getOwnerName());
        System.out.println(ford.speed());
        ford.tempControl();
    }
}