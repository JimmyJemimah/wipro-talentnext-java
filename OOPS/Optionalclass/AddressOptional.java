import java.util.Optional;
import java.util.Scanner;

public class AddressOptional {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter address (or press Enter): ");
        String address = sc.nextLine();

        if (address.trim().isEmpty())
            address = null;

        String result = Optional.ofNullable(address).orElse("India");

        System.out.println(result);

        sc.close();
    }
}