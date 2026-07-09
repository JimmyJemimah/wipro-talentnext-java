import java.util.Scanner;
import java.util.StringJoiner;

public class MergeStringJoiner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringJoiner s1 = new StringJoiner("-");

        System.out.print("Enter number of cities in s1: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n1;i++){
            s1.add(sc.nextLine());
        }

        StringJoiner s2 = new StringJoiner("-");

        System.out.print("Enter number of cities in s2: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n2;i++){
            s2.add(sc.nextLine());
        }

        StringJoiner merge1 = new StringJoiner("-");
        merge1.merge(s2);
        merge1.merge(s1);

        StringJoiner merge2 = new StringJoiner("-");
        merge2.merge(s1);
        merge2.merge(s2);

        System.out.println("s1 merged to s2 : " + merge1);
        System.out.println("s2 merged to s1 : " + merge2);

        sc.close();
    }
}