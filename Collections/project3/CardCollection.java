package project3;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

class Card {
    private char symbol;
    private int number;

    public Card(char symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // TreeMap keeps keys sorted alphabetically. 
        // putIfAbsent ensures we only save the *first* occurrence of each symbol.
        Map<Character, Integer> uniqueCards = new TreeMap<>();
        int totalCardsEntered = 0;

        // Loop keeps running until all 4 unique symbols ('a', 'b', 'c', 'd') are collected
        while (uniqueCards.size() < 4) {
            System.out.println("Enter a card :");
            char symbol = scanner.next().charAt(0);
            int number = scanner.nextInt();
            totalCardsEntered++;

            // Store the symbol and number if it hasn't been added yet
            uniqueCards.putIfAbsent(symbol, number);
        }

        System.out.println("Four symbols gathered in " + totalCardsEntered + " cards.");
        System.out.println("Cards in Set are :");
        
        // Print the sorted unique cards matching the sample format
        for (Map.Entry<Character, Integer> entry : uniqueCards.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        scanner.close();
    }
}