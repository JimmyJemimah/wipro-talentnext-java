package Assignment3;

// Custom Functional Interface matching the constructor signature
interface PrimeCheckInterface {
    NumberChecker check(int n);
}

// Class with a parameterized constructor
class NumberChecker {
    public NumberChecker(int n) {
        if (isPrime(n)) {
            System.out.println(n + " is Prime");
        } else {
            System.out.println(n + " is Not Prime");
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class ConstructorRef {
    public static void main(String[] args) {
        // Reference to a constructor
        PrimeCheckInterface checkerRef = NumberChecker::new;

        // Invoking the interface method instantiates the class and triggers constructor logic
        System.out.println("Checking numbers using Constructor Reference:");
        checkerRef.check(17);
        checkerRef.check(20);
    }
}