import java.util.Scanner;

public class ReplaceVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean hasVowel = false;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            char lowerCh = Character.toLowerCase(ch);

            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                hasVowel = true;
                result.append('z');
            } else {
                result.append(ch);
            }
        }

        if (hasVowel) {
            System.out.println("Modified string: " + result.toString());
        } else {
            System.out.println("Original string: " + input);
            System.out.println("No vowels present");
        }

        scanner.close();
    }
}