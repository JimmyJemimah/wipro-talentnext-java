import java.util.ArrayList;

public class VideoStore {
    private ArrayList<Video> store;

    // Constructor
    public VideoStore() {
        store = new ArrayList<>();
    }

    // Add video
    public void addVideo(String name) {
        store.add(new Video(name));
        System.out.println("Video added successfully!");
    }

    // Check out video
    public void doCheckout(String name) {
        for (Video v : store) {
            if (v.getName().equalsIgnoreCase(name)) {
                v.doCheckout();
                System.out.println("Video checked out!");
                return;
            }
        }
        System.out.println("Video not found!");
    }

    // Return video
    public void doReturn(String name) {
        for (Video v : store) {
            if (v.getName().equalsIgnoreCase(name)) {
                v.doReturn();
                System.out.println("Video returned!");
                return;
            }
        }
        System.out.println("Video not found!");
    }

    // Give rating
    public void receiveRating(String name, int rating) {
        for (Video v : store) {
            if (v.getName().equalsIgnoreCase(name)) {
                v.receiveRating(rating);
                System.out.println("Rating given!");
                return;
            }
        }
        System.out.println("Video not found!");
    }

    // List inventory
    public void listInventory() {
        System.out.println("\n--- Video Inventory ---");
        for (Video v : store) {
            System.out.println("Name: " + v.getName() +
                    " | Checked Out: " + v.getCheckout() +
                    " | Rating: " + v.getRating());
        }
    }
}