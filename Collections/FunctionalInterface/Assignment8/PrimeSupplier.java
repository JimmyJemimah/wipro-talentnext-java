package Assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PrimeSupplier {
    public static void main(String[] args) {
        // Define a Supplier that produces an ArrayList containing the first 10 prime numbers
        Supplier<List<Integer>> primeGenerator = () -> {
            List<Integer> primes = new ArrayList<>();
            int count = 0;
            int number = 2; // Initial prime candidate

            while (count < 10) {
                if (isPrime(number)) {
                    primes.add(number);
                    count++;
                }
                number++;
            }
            return primes;
        };

        // Get the generated list from the Supplier
        List<Integer> firstTenPrimes = primeGenerator.get();

        System.out.println("First 10 Prime Numbers (Generated via Supplier):");
        System.out.println(firstTenPrimes);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}