import java.util.Scanner;

public class MergeDescendingArrays {

    // Helper method to sort an array in descending order using Bubble Sort
    public static void sortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept Array 1
        System.out.print("Enter size of first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        System.out.println("Enter " + size1 + " elements for first array:");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Accept Array 2
        System.out.print("Enter size of second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        System.out.println("Enter " + size2 + " elements for second array:");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Step 1: Sort both arrays in descending order individually
        sortDescending(array1);
        sortDescending(array2);

        // Step 2: Merge sorted descending arrays into one descending array
        int[] mergedArray = new int[size1 + size2];
        int i = 0, j = 0, k = 0;

        while (i < size1 && j < size2) {
            if (array1[i] >= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }

        // Copy remaining elements
        while (i < size1) {
            mergedArray[k++] = array1[i++];
        }
        while (j < size2) {
            mergedArray[k++] = array2[j++];
        }

        // Display results
        System.out.print("\nMerged Array in Descending Order: ");
        for (int val : mergedArray) {
            System.out.print(val + " ");
        }
        System.out.println();

        scanner.close();
    }
}