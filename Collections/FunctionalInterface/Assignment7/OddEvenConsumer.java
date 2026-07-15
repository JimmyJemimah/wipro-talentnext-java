package Assignment7;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class OddEvenConsumer {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 5, 12, 19, 24, 33, 40, 57, 66, 71);

        // Define a Consumer to verify and print whether the number is odd or even
        Consumer<Integer> oddEvenChecker = n -> {
            if (n % 2 == 0) {
                System.out.println(n + " even");
            } else {
                System.out.println(n + " odd");
            }
        };

        System.out.println("Output Analysis:");
        numbers.forEach(oddEvenChecker);
    }
}