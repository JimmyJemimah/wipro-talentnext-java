import java.util.Scanner;

public class MarksRangeFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[30];
        int[] rangeCount = new int[10]; // 10 ranges

        System.out.println("Enter marks for 30 students (0 to 100):");
        for (int i = 0; i < 30; i++) {
            marks[i] = scanner.nextInt();
            int mark = marks[i];

            if (mark >= 0 && mark <= 10) rangeCount[0]++;
            else if (mark >= 11 && mark <= 20) rangeCount[1]++;
            else if (mark >= 21 && mark <= 30) rangeCount[2]++;
            else if (mark >= 31 && mark <= 40) rangeCount[3]++;
            else if (mark >= 41 && mark <= 50) rangeCount[4]++;
            else if (mark >= 51 && mark <= 60) rangeCount[5]++;
            else if (mark >= 61 && mark <= 70) rangeCount[6]++;
            else if (mark >= 71 && mark <= 80) rangeCount[7]++;
            else if (mark >= 81 && mark <= 90) rangeCount[8]++;
            else if (mark >= 91 && mark <= 100) rangeCount[9]++;
        }

        System.out.println("\nStudent Count per Range:");
        String[] ranges = {
            "0% to 10%", "11% to 20%", "21% to 30%", "31% to 40%", "41% to 50%",
            "51% to 60%", "61% to 70%", "71% to 80%", "81% to 90%", "91% to 100%"
        };

        for (int i = 0; i < 10; i++) {
            System.out.println(ranges[i] + ": " + rangeCount[i] + " student(s)");
        }

        scanner.close();
    }
}