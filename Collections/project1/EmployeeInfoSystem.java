package project1;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private int empNo;
    private String empName;
    private String joinDate;
    private char designCode;
    private String department;
    private double basic;
    private double hra;
    private double it;

    public Employee(int empNo, String empName, String joinDate, char designCode, String department, double basic, double hra, double it) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.designCode = designCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    public int getEmpNo() { return empNo; }
    public String getEmpName() { return empName; }
    public char getDesignCode() { return designCode; }
    public String getDepartment() { return department; }
    
    // Method to calculate total salary based on designation rules
    public double calculateSalary() {
        double da = 0;
        switch (designCode) {
            case 'e': da = 20000; break;
            case 'c': da = 32000; break;
            case 'k': da = 12000; break;
            case 'r': da = 15000; break;
            case 'm': da = 40000; break;
        }
        return basic + hra + da - it;
    }

    // Method to fetch designation name text
    public String getDesignationName() {
        switch (designCode) {
            case 'e': return "Engineer";
            case 'c': return "Consultant";
            case 'k': return "Clerk";
            case 'r': return "Receptionist";
            case 'm': return "Manager";
            default: return "Unknown";
        }
    }
}

public class EmployeeInfoSystem {
    public static void main(String[] args) {
        // Checking if an Employee ID was provided via command-line arguments
        if (args.length < 1) {
            System.out.println("Error: Please provide an Employee ID as a command-line argument.");
            System.out.println("Usage: java project1.EmployeeInfoSystem <Employee_ID>");
            return;
        }

        int searchId;
        try {
            searchId = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Employee ID must be a valid integer number.");
            return;
        }

        // Populating database lists matching the assignment specifications
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1001, "Ashish", "27/04/2009", 'e', "R&D", 20000, 8000, 3000));
        employeeList.add(new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000));
        employeeList.add(new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000));
        employeeList.add(new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000));
        employeeList.add(new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000));
        employeeList.add(new Employee(1006, "Suman", "1/1/2000", 'e', "Manufacturing", 23000, 9000, 4400));
        employeeList.add(new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000));

        // Finding the requested employee
        Employee targetEmp = null;
        for (Employee emp : employeeList) {
            if (emp.getEmpNo() == searchId) {
                targetEmp = emp;
                break;
            }
        }

        // Display results according to format specifications
        if (targetEmp == null) {
            System.out.println("There is no employee with empid : " + searchId);
        } else {
            System.out.printf("%-10s %-12s %-12s %-15s %-10s\n", "Emp No.", "Emp Name", "Department", "Designation", "Salary");
            System.out.println("-------------------------------------------------------------------------");
            System.out.printf("%-10d %-12s %-12s %-15s %-10.0f\n", 
                targetEmp.getEmpNo(), 
                targetEmp.getEmpName(), 
                targetEmp.getDepartment(), 
                targetEmp.getDesignationName(), 
                targetEmp.calculateSalary()
            );
        }
    }
}