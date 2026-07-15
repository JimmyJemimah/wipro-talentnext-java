package Assignment2;

import java.util.HashSet;
import java.util.Iterator;

public class EmployeeHashSet {
    public static void main(String[] args) {
        HashSet<String> employees = new HashSet<>();

        employees.add("Manoj");
        employees.add("Anitha");
        employees.add("Sureka");
        employees.add("Harish");

        System.out.println("Retrieving employee names one by one:");
        Iterator<String> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}