package project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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

public class CardGrouping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // TreeMap keeps the key symbols automatically sorted in alphabetical order
        Map<Character, List<Card>> cardMap = new TreeMap<>();

        System.out.println("Enter Number of Cards :");
        int totalCards = scanner.nextInt();

        for (int i = 1; i <= totalCards; i++) {
            System.out.println("Enter card " + i + ":");
            char symbol = scanner.next().charAt(0);
            int number = scanner.nextInt();

            Card card = new Card(symbol, number);

            // If the symbol list doesn't exist yet, initialize it
            cardMap.putIfAbsent(symbol, new ArrayList<>());
            // Add the card to its respective symbol group
            cardMap.get(symbol).add(card);
        }

        // 1. Display distinct symbols gathered
        System.out.println("Distinct Symbols are :");
        for (Character symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        // 2. Iterate through groups to compute counts and sums
        for (Map.Entry<Character, List<Card>> entry : cardMap.entrySet()) {
            char symbol = entry.getKey();
            List<Card> cards = entry.getValue();

            System.out.println("Cards in " + symbol + " Symbol");
            
            int sum = 0;
            for (Card c : cards) {
                System.out.println(c.getSymbol() + " " + c.getNumber());
                sum += c.getNumber();
            }

            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        scanner.close();
    }
}