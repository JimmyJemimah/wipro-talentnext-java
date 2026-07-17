package Multithreading.Threadcreation;

import java.util.Random;

class ColourRunnable implements Runnable {
    public void run() {
        // Fixed: Capitalized 'String'
        String colours[] = {"red", "green", "blue", "yellow", "orange"};
        Random rand = new Random();
        
        while (true) {
            int index = rand.nextInt(colours.length);
            String selectedColour = colours[index];
            
            // Fixed: Corrected 'println' spelling and variable casing 'selectedColour'
            System.out.println(selectedColour);
            
            if (selectedColour.equals("red")) {
                System.out.println("Stopped because red was found.");
                break;
            }
        }
    }
} // Closes ColourRunnable

public class Assignment2 {
    public static void main(String[] args) {
        ColourRunnable target = new ColourRunnable();
        Thread t1 = new Thread(target);
        t1.start();
    }
} // Closes Assignment2