import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        // Hardcoded example from TC5 document or dynamic input
        int[] array1 = {15, 18, 42, 51};
        int[] array2 = {8, 11, 16, 17, 44, 58, 71, 74};

        int m = array1.length;
        int n = array2.length;
        int[] array3 = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Two-pointer merge algorithm
        while (i < m && j < n) {
            if (array1[i] <= array2[j]) {
                array3[k++] = array1[i++];
            } else {
                array3[k++] = array2[j++];
            }
        }

        // Copy remaining elements of array1
        while (i < m) {
            array3[k++] = array1[i++];
        }

        // Copy remaining elements of array2
        while (j < n) {
            array3[k++] = array2[j++];
        }

        // Print merged array
        System.out.print("Merged Array: ");
        for (int num : array3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}