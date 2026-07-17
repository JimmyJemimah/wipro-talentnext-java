
class EvenThread extends Thread {
    public void run() {
        for (int j = 2; j <= 20; j += 2) {
            System.out.println("Even: " + j);
        }
    }
}

class OddThread extends Thread {
    public void run() {
        for (int j = 1; j <= 20; j += 2) {
            System.out.println("Odd: " + j);
        }
    }
}

public class Assignment2 { 
    public static void main(String[] args) {
        EvenThread even = new EvenThread();
        OddThread odd = new OddThread();

        try {
            even.start();
            even.join(); // wait for even to finish

            odd.start();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}