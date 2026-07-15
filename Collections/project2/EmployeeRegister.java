package project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String address;

    public Employee(String firstName, String lastName, String mobileNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMobileNumber() { return mobileNumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
}

public class EmployeeRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        System.out.println("Enter the Number of Employees");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= count; i++) {
            System.out.println("Enter Employee " + i + " Details:");
            System.out.println("Enter the Firstname");
            String firstName = scanner.nextLine();
            
            System.out.println("Enter the Lastname");
            String lastName = scanner.nextLine();
            
            System.out.println("Enter the Mobile");
            String mobile = scanner.nextLine();
            
            System.out.println("Enter the Email");
            String email = scanner.nextLine();
            
            System.out.println("Enter the Address");
            String address = scanner.nextLine();

            employeeList.add(new Employee(firstName, lastName, mobile, email, address));
        }

        // Sort employees alphabetically by their first name
        Collections.sort(employeeList, Comparator.comparing(Employee::getFirstName));

        System.out.println("\nEmployee List:\n");
        // Apply matching format specifications requested in the requirements note
        System.out.format("%-15s %-15s %-15s %-30s %-15s\n", "FirstName", "LastName", "MobileNumber", "Email", "Address");
        
        for (Employee emp : employeeList) {
            System.out.format("%-15s %-15s %-15s %-30s %-15s\n", 
                emp.getFirstName(), emp.getLastName(), emp.getMobileNumber(), emp.getEmail(), emp.getAddress());
        }
        
        scanner.close();
    }
}