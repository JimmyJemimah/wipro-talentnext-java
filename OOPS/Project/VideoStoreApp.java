import java.util.Scanner;

public class VideoStoreApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoStore store = new VideoStore();

        int choice;

        do {
            System.out.println("\n--- Video Store Menu ---");
            System.out.println("1. Add Video");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Rate Video");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter video name: ");
                    String name = sc.nextLine();
                    store.addVideo(name);
                    break;

                case 2:
                    System.out.print("Enter video name: ");
                    store.doCheckout(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter video name: ");
                    store.doReturn(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter video name: ");
                    String video = sc.nextLine();
                    System.out.print("Enter rating: ");
                    int rating = sc.nextInt();
                    store.receiveRating(video, rating);
                    break;

                case 5:
                    store.listInventory();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}