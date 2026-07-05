import java.util.Arrays;

public class Q6_SortArray {
    public static void main(String[] args) {

        int[] arr = {50, 20, 70, 10, 40};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}