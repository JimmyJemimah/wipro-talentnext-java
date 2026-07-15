package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PalindromeFilterPredicate {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("radar", "hello", "madam", "java", "level", "world", "noon", "racecar", "code", "kayak");
        System.out.println("Original Words: " + words);

        // Define a Predicate to check if a word is a palindrome
        Predicate<String> isPalindrome = word -> {
            String cleanWord = word.replaceAll("\\s+", "").toLowerCase();
            String reversed = new StringBuilder(cleanWord).reverse().toString();
            return cleanWord.equals(reversed);
        };

        List<String> palindromes = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome.test(word)) {
                palindromes.add(word);
            }
        }

        System.out.println("Palindrome Words: " + palindromes);
    }
}