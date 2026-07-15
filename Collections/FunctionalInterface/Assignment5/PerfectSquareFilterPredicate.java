package Assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PerfectSquareFilterPredicate {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 8, 9, 12, 16, 23, 25, 30, 36);
        System.out.println("Original Numbers: " + numbers);

        // Define a Predicate to check if a number is a perfect square
        Predicate<Integer> isPerfectSquare = num -> {
            if (num < 0) return false;
            long sqrt = Math.round(Math.sqrt(num));
            return sqrt * sqrt == num;
        };

        List<Integer> perfectSquares = new ArrayList<>();
        for (int num : numbers) {
            if (isPerfectSquare.test(num)) {
                perfectSquares.add(num);
            }
        }

        System.out.println("Perfect Square Numbers: " + perfectSquares);
    }
}