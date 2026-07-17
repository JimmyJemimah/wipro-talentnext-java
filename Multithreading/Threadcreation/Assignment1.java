class MyThread extends Thread{
    public void run(){
        System.out.println("Thread Name: "+Thread.currentThread().getName());


        
    }
}
public class Assignment1{
    public static void main(String[] args){
        MyThread t1 = new MyThread();
        MyThread t2=new MyThread();
        t1.setName("Scooby");
        t2.setName("Shaggy");
        t1.start();
        t2.start();
    }

}
    