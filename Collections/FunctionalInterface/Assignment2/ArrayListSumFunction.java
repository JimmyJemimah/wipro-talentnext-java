package Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ArrayListSumFunction {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i * 5); // 5, 10, 15, ..., 50
        }
        System.out.println("Numbers: " + numbers);

        // Define a Function that takes a List<Integer> and returns its sum as an Integer
        Function<List<Integer>, Integer> sumCalculator = list -> {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            return sum;
        };

        int totalSum = sumCalculator.apply(numbers);
        System.out.println("Sum of all elements: " + totalSum);
    }
}