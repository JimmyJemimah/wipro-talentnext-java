import java.util.Arrays;

public class Q5_LargestAndSmallestTwo {
    public static void main(String[] args) {

        int[] arr = {10, 4, 50, 23, 89, 2, 67};

        Arrays.sort(arr);

        System.out.println("Smallest Two: " + arr[0] + " " + arr[1]);

        System.out.println("Largest Two: " +
                arr[arr.length - 2] + " " +
                arr[arr.length - 1]);
    }
}