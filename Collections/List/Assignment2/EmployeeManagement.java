package Assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee {
    private int empId;
    private String empName;
    private String email;
    private String gender;
    private float salary;

    public Employee(int empId, String empName, String email, String gender, float salary) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void GetEmployeeDetails() {
        System.out.println("ID: " + empId + " | Name: " + empName + " | Email: " + email + " | Gender: " + gender + " | Salary: " + salary);
    }

    @Override
    public String toString() {
        return "ID: " + empId + ", Name: " + empName + ", Email: " + email + ", Gender: " + gender + ", Salary: " + salary;
    }
}

class EmployeeDB {
    private List<Employee> list = new ArrayList<>();

    public boolean addEmployee(Employee e) {
        return list.add(e);
    }

    public boolean deleteEmployee(int empId) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getEmpId() == empId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public String showPaySlip(int empId) {
        for (Employee emp : list) {
            if (emp.getEmpId() == empId) {
                return "Payslip for " + emp.toString();
            }
        }
        return "Employee with ID " + empId + " not found.";
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("No records found in database.");
        } else {
            for (Employee emp : list) {
                emp.GetEmployeeDetails();
            }
        }
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        EmployeeDB db = new EmployeeDB();

        Employee emp1 = new Employee(101, "Aravind", "aravind@mail.com", "Male", 45000.0f);
        Employee emp2 = new Employee(102, "Sneha", "sneha@mail.com", "Female", 55000.0f);

        System.out.println("Adding Employees:");
        System.out.println("Emp 1 Added: " + db.addEmployee(emp1));
        System.out.println("Emp 2 Added: " + db.addEmployee(emp2));

        System.out.println("\nAll Employees Info:");
        db.displayAll();

        System.out.println("\nPayslip Generation:");
        System.out.println(db.showPaySlip(101));

        System.out.println("\nDeleting Employee 101:");
        System.out.println("Deleted successfully: " + db.deleteEmployee(101));

        System.out.println("\nAll Employees Info after deletion:");
        db.displayAll();
    }
}