package Assignment1;

import java.util.ArrayList;
import java.util.Random;

public class PrimeFilter {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Random random = new Random();

        // Add 25 random numbers between 1 and 100
        for (int i = 0; i < 25; i++) {
            al.add(random.nextInt(100) + 1);
        }
        System.out.println("Generated Numbers: " + al);

        System.out.println("\nPrime Numbers:");
        // Using forEach with a lambda expression to check and print primes
        al.forEach(n -> {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        });
        System.out.println();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}