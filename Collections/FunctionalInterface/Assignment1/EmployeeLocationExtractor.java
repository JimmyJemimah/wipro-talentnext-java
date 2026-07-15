package Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee {
    int id;
    String name;
    String location;
    double salary;

    public Employee(int id, String name, String location, double salary) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.salary = salary;
    }
}

public class EmployeeLocationExtractor {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Amit", "Pune", 50000));
        employees.add(new Employee(2, "Rahul", "Mumbai", 60000));
        employees.add(new Employee(3, "Priya", "Chennai", 45000));
        employees.add(new Employee(4, "Sneha", "Bangalore", 70000));
        employees.add(new Employee(5, "Vikram", "Pune", 55000));

        // Define a Function to extract the location from an Employee object
        Function<Employee, String> locationExtractor = emp -> emp.location;

        List<String> locations = new ArrayList<>();
        for (Employee emp : employees) {
            locations.add(locationExtractor.apply(emp));
        }

        System.out.println("Extracted Locations: " + locations);
    }
}