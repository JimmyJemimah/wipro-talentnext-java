public class Video {
    private String videoName;
    private boolean checkout;
    private int rating;

    // Constructor
    public Video(String name) {
        this.videoName = name;
        this.checkout = false;
        this.rating = 0;
    }

    // Get video name
    public String getName() {
        return videoName;
    }

    // Check out video
    public void doCheckout() {
        checkout = true;
    }

    // Return video
    public void doReturn() {
        checkout = false;
    }

    // Receive rating
    public void receiveRating(int rating) {
        this.rating = rating;
    }

    // Get rating
    public int getRating() {
        return rating;
    }

    // Check if video is checked out
    public boolean getCheckout() {
        return checkout;
    }
}