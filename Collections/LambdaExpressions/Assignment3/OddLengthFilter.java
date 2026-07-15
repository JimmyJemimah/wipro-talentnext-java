package Assignment3;

import java.util.ArrayList;

public class OddLengthFilter {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Apple");
        al.add("Banana");
        al.add("Kiwi");
        al.add("Orange");
        al.add("Plum");
        al.add("Mango");
        al.add("Pear");
        al.add("Cherry");
        al.add("Grape");
        al.add("Melon");

        System.out.println("All Words: " + al);
        System.out.println("\nWords with Odd Lengths:");
        
        // Lambda checking if string length % 2 != 0
        al.forEach(str -> {
            if (str.length() % 2 != 0) {
                System.out.println(str + " (Length: " + str.length() + ")");
            }
        });
    }
}