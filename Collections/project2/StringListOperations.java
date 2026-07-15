package project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice :\n");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid selection.");
                scanner.nextLine();
                choice = 0;
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter the item to be inserted:");
                    String itemToInsert = scanner.nextLine();
                    list.add(itemToInsert);
                    System.out.println("Inserted successfully");
                    break;
                case 2:
                    System.out.println("Enter the item to search :");
                    String itemToSearch = scanner.nextLine();
                    if (list.contains(itemToSearch)) {
                        System.out.println("Item found in the list.");
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the item to delete :");
                    String itemToDelete = scanner.nextLine();
                    if (list.remove(itemToDelete)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Item does not exist.");
                    }
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        System.out.println("The Items in the list are :");
                        for (String str : list) {
                            System.out.println(str);
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid entry. Choose options 1 through 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}