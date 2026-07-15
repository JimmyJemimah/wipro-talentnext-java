package Assignment1;

// Custom Functional Interface
interface FactorialInterface {
    int getFactorial(int n);
}

// Class containing the instance method
class MathOperations {
    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

public class InstanceMethodRef {
    public static void main(String[] args) {
        // Instantiate the object containing the instance method
        MathOperations mathObj = new MathOperations();

        // Method reference to an instance method of a particular object
        FactorialInterface factRef = mathObj::factorial;

        // Invoke the method via the functional interface
        int input = 5;
        System.out.println("Factorial of " + input + " is: " + factRef.getFactorial(input));
    }
}