import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input string: ");
        String input = scanner.nextLine();

        // Count frequencies while preserving insertion order
        StringBuilder checked = new StringBuilder();

        System.out.println("Output:");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Process each unique character only once
            if (checked.indexOf(String.valueOf(ch)) == -1) {
                checked.append(ch);
                int count = 0;

                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == ch) {
                        count++;
                    }
                }
                System.out.println(ch + " - " + count);
            }
        }

        scanner.close();
    }
}