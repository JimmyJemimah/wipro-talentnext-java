package Assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeEven {
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(12, -4, -7, -8, 0, -14, 15, -22, 9);
        System.out.println("Original ArrayList: " + al);

        // Filter negative even numbers and collect into a new ArrayList
        List<Integer> filteredList = al.stream()
                                       .filter(n -> n < 0 && n % 2 == 0)
                                       .collect(Collectors.toList());

        System.out.println("Filtered ArrayList (Negative Even Numbers): " + filteredList);
    }
}