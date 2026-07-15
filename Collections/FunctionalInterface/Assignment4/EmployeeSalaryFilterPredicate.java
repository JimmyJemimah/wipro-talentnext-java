package Assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}

public class EmployeeSalaryFilterPredicate {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Amit", 12000));
        employees.add(new Employee(102, "Sunil", 8500));
        employees.add(new Employee(103, "Kiran", 15000));
        employees.add(new Employee(104, "Ravi", 9200));
        employees.add(new Employee(105, "Pooja", 25000));

        // Define a Predicate to verify if salary is less than 10000
        Predicate<Employee> isLowSalary = emp -> emp.getSalary() < 10000;

        System.out.println("Employees with salary less than 10000:");
        for (Employee emp : employees) {
            if (isLowSalary.test(emp)) {
                System.out.println("Name: " + emp.getName() + " | Salary: " + emp.getSalary());
            }
        }
    }
}