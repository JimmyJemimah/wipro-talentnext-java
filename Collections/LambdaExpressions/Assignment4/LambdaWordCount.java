package Assignment4;

// Functional Interface containing exactly one abstract method
interface WordCount {
    int count(String str);
}

public class LambdaWordCount {
    public static void main(String[] args) {
        // Implementing the abstract method using a Lambda Expression
        WordCount wordCounter = str -> {
            if (str == null || str.trim().isEmpty()) {
                return 0;
            }
            // Split string by any sequence of whitespace characters
            String[] words = str.trim().split("\\s+");
            return words.length;
        };

        // Test implementation string
        String testInput = "Complete the below hands-on assignments before proceeding";
        
        // Invoke the lambda implementation
        int result = wordCounter.count(testInput);

        System.out.println("Input String: \"" + testInput + "\"");
        System.out.println("Total Word Count: " + result);
    }
}