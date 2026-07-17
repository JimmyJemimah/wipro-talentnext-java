

class RaceThread extends Thread {

    static boolean raceOver = false;

    public RaceThread(String name) {
        setName(name);
    }

    public void run() {

        for (int i = 1; i <= 100; i++) {

            if (raceOver) {
                break;
            }

            // Hare sleeps after running 60 meters
            if (getName().equals("Hare") && i == 60) {

                try {
                    System.out.println("Hare is sleeping...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }

            }

            System.out.println(getName() + " : " + i + " meters");

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }

        }

        if (!raceOver) {
            raceOver = true;
            System.out.println(getName() + " wins the race!");
        }

    }

}

public class project {

    public static void main(String[] args) {

        RaceThread hare = new RaceThread("Hare");
        RaceThread tortoise = new RaceThread("Tortoise");

        // Part (b): Hare has higher priority
        hare.setPriority(Thread.MAX_PRIORITY);
        tortoise.setPriority(Thread.MIN_PRIORITY);

        hare.start();
        tortoise.start();

    }

}