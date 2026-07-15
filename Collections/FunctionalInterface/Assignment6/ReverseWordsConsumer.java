package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class ReverseWordsConsumer {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList(
            "alpha", "beta", "gamma", "delta", "epsilon", 
            "zeta", "eta", "theta", "iota", "kappa"
        ));
        System.out.println("Original List: " + words);

        // Define a Consumer to modify the list elements in place using a ListIterator
        Consumer<List<String>> reverseUpdater = list -> {
            ListIterator<String> iterator = list.listIterator();
            while (iterator.hasNext()) {
                String original = iterator.next();
                String reversed = new StringBuilder(original).reverse().toString();
                iterator.set(reversed); // Updates the elements in place
            }
        };

        // Accept the list into the consumer
        reverseUpdater.accept(words);

        System.out.println("Updated List (Reversed Words): " + words);
    }
}