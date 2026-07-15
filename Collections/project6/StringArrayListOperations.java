package project6;

import java.util.ArrayList;

public class StringArrayListOperations {

    public static ArrayList<String> performStringOperations(String S1, String S2) {
        ArrayList<String> resultList = new ArrayList<>();

        // 1. Character in each alternate index of S1 should be replaced with S2
        StringBuilder op1 = new StringBuilder();
        for (int i = 0; i < S1.length(); i++) {
            if (i % 2 == 0) {
                op1.append(S2);
            } else {
                op1.append(S1.charAt(i));
            }
        }
        resultList.add(op1.toString());

        // 2. If S2 appears more than once in S1, replace the last occurrence with reverse of S2, else return S1+S2
        int firstOccur = S1.indexOf(S2);
        int lastOccur = S1.lastIndexOf(S2);
        if (firstOccur != -1 && firstOccur != lastOccur) {
            String reversedS2 = new StringBuilder(S2).reverse().toString();
            String op2 = S1.substring(0, lastOccur) + reversedS2 + S1.substring(lastOccur + S2.length());
            resultList.add(op2);
        } else {
            resultList.add(S1 + S2);
        }

        // 3. If S2 appears more than once in S1, delete the first occurrence of S2 in S1, else return S1
        if (firstOccur != -1 && firstOccur != lastOccur) {
            String op3 = S1.substring(0, firstOccur) + S1.substring(firstOccur + S2.length());
            resultList.add(op3);
        } else {
            resultList.add(S1);
        }

        // 4. Divide S2 into two halves and add first half to beginning and second half to the end of S1
        int n = S2.length();
        int mid = (n % 2 != 0) ? (n / 2) + 1 : n / 2;
        String firstHalf = S2.substring(0, mid);
        String secondHalf = S2.substring(mid);
        String op4 = firstHalf + S1 + secondHalf;
        resultList.add(op4);

        // 5. If S1 contains characters that are in S2 change all such characters to *
        StringBuilder op5 = new StringBuilder();
        for (int i = 0; i < S1.length(); i++) {
            char ch = S1.charAt(i);
            if (S2.indexOf(ch) != -1) {
                op5.append('*');
            } else {
                op5.append(ch);
            }
        }
        resultList.add(op5.toString());

        return resultList;
    }

    public static void main(String[] args) {
        // Test inputs matching the sample criteria perfectly
        String S1 = "JAVAJAVA";
        String S2 = "VA";

        System.out.println("S1 = \"" + S1 + "\"");
        System.out.println("S2 = \"" + S2 + "\"");

        ArrayList<String> output = performStringOperations(S1, S2);

        System.out.println("\nCalculated ArrayList Contents:");
        for (int i = 0; i < output.size(); i++) {
            System.out.println((i + 1) + ". " + output.get(i));
        }

        System.out.println("\nOutput Format List String:");
        System.out.println(output);
    }
}