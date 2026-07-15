package Assignment2;

import java.util.ArrayList;

public class ReverseStrings {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Java");
        al.add("Lambda");
        al.add("Collection");
        al.add("Stream");
        al.add("Filter");
        al.add("List");
        al.add("Set");
        al.add("Map");
        al.add("Vector");
        al.add("Interface");

        System.out.println("Original Words: " + al);
        System.out.println("\nWords in Reverse Order:");
        
        // Use forEach with a lambda expression to reverse each individual string block
        al.forEach(str -> {
            String reversed = new StringBuilder(str).reverse().toString();
            System.out.println(str + " -> " + reversed);
        });
    }
}