package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class NumericList {
    public static void main(String[] args) {
        // Using Number as the type parameter allows holding Integer, Float, Double, etc.
        List<Number> numericList = new ArrayList<>();

        numericList.add(10);        // Integer
        numericList.add(20.5f);     // Float
        numericList.add(30.99);     // Double
        numericList.add(40L);       // Long

        System.out.println("Numbers stored in the list:");
        for (Number num : numericList) {
            System.out.println(num + " (Type: " + num.getClass().getSimpleName() + ")");
        }
    }
}