package Assignment3;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetOperations {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Banana");
        set.add("Apple");
        set.add("Mango");
        set.add("Orange");

        // a) Reverse the elements of the Collection
        TreeSet<String> reversedSet = (TreeSet<String>) set.descendingSet();
        System.out.println("Reversed TreeSet elements: " + reversedSet);

        // b) Iterate the elements of the TreeSet using Iterator
        System.out.println("\nIterating using Iterator (Natural Order):");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // c) Check if a particular element exists or not
        String target = "Mango";
        if (set.contains(target)) {
            System.out.println("\nElement '" + target + "' exists in the TreeSet.");
        } else {
            System.out.println("\nElement '" + target + "' does not exist in the TreeSet.");
        }
    }
}