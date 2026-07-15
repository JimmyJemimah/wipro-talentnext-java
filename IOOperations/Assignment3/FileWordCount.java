package Assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileWordCount {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: Please provide both input and output file names as arguments.");
            System.out.println("Usage: java Assignment3.FileWordCount <inputFile.txt> <outputFile.txt>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        // TreeMap automatically sorts keys alphabetically
        Map<String, Integer> wordCounts = new TreeMap<>();

        // Read from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split lines by whitespace characters (spaces, tabs, etc.)
                String[] words = line.trim().split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        // Write the sorted frequencies to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Word count processing complete. Check '" + outputFileName + "' for results.");
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
        }
    }
}