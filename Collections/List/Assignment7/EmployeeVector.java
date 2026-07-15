package Assignment7;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class Employee {
    private int empId;
    private String name;
    private String designation;

    public Employee(int empId, String name, String designation) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "ID: " + empId + " | Name: " + name + " | Designation: " + designation;
    }
}

public class EmployeeVector {
    public static void main(String[] args) {
        // Create a Vector specifically targeting Employee objects
        Vector<Employee> employeeVector = new Vector<>();

        // Add elements
        employeeVector.add(new Employee(201, "Rahul", "Software Engineer"));
        employeeVector.add(new Employee(202, "Priya", "Data Analyst"));
        employeeVector.add(new Employee(203, "Amit", "Project Manager"));

        // 1. Traverse using an Iterator
        System.out.println("--- Listing Elements using Iterator ---");
        Iterator<Employee> iterator = employeeVector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        // 2. Traverse using legacy Enumeration
        System.out.println("--- Listing Elements using Enumeration ---");
        Enumeration<Employee> enumeration = employeeVector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}