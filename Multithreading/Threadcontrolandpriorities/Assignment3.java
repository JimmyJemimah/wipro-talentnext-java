class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " running");
        }
    }
}

public class Assignment3 {
    public static void main(String[] args) {

        PriorityThread t1 = new PriorityThread("MIN_PRIORITY");
        PriorityThread t2 = new PriorityThread("NORM_PRIORITY");
        PriorityThread t3 = new PriorityThread("MAX_PRIORITY");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}