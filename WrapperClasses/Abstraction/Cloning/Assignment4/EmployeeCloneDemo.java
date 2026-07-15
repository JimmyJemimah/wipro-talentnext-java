package Assignment4;

class Employee implements Cloneable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayProperties(String label) {
        System.out.println(label + " -> Name: " + name + ", Salary: " + salary);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class EmployeeCloneDemo {
    public static void main(String[] args) {
        try {
            Employee originalEmp = new Employee("Alice", 50000.0);
            Employee clonedEmp = (Employee) originalEmp.clone();
            
            System.out.println("--- Before Modifying Original Object ---");
            originalEmp.displayProperties("Original Employee");
            clonedEmp.displayProperties("Cloned Employee");
            
            originalEmp.setName("Bob");
            originalEmp.setSalary(65000.0);
            
            System.out.println("\n--- After Modifying Original Object ---");
            originalEmp.displayProperties("Original Employee (Modified)");
            clonedEmp.displayProperties("Cloned Employee (Unchanged)");
            
            System.out.println("\nObservation: Changing the original object does not affect the cloned object because clone() creates a distinct, independent copy in memory.");
            
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
        }
    }
}