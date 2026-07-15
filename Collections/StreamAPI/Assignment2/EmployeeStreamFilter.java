package Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private int empNo;
    private String name;
    private int age;
    private String location;

    public Employee(int empNo, String name, int age, String location) {
        this.empNo = empNo;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "EmpNo: " + empNo + " | Name: " + name + " | Age: " + age + " | Location: " + location;
    }
}

public class EmployeeStreamFilter {
    public static void main(String[] args) {
        List<Employee> al = new ArrayList<>();
        al.add(new Employee(1, "Amit", 28, "Pune"));
        al.add(new Employee(2, "Rahul", 32, "Mumbai"));
        al.add(new Employee(3, "Priya", 24, "Pune"));
        al.add(new Employee(4, "Sneha", 29, "Bangalore"));
        al.add(new Employee(5, "Vikram", 35, "Pune"));

        // Filter by location "Pune" and collect into a separate list
        List<Employee> puneEmployees = al.stream()
                                         .filter(emp -> "Pune".equalsIgnoreCase(emp.getLocation()))
                                         .collect(Collectors.toList());

        System.out.println("Employees located in Pune:");
        puneEmployees.forEach(System.out.println);
    }
}