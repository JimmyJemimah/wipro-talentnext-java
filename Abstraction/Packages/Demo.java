import test.Foundation;

public class Demo {

    public static void main(String[] args) {

        Foundation obj = new Foundation();

        // System.out.println(obj.var1); // Private - Not Accessible
        // System.out.println(obj.var2); // Default - Not Accessible
        // System.out.println(obj.var3); // Protected - Not Accessible

        System.out.println("Public Variable:");
        System.out.println(obj.var4);
    }
}