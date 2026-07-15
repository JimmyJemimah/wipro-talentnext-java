package Assignment2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapOperations {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        
        map.put("HR", "Alice");
        map.put("IT", "Bob");
        map.put("Finance", "Charlie");

        // a) Check if a particular key exists or not
        String targetKey = "IT";
        System.out.println("Does key '" + targetKey + "' exist? " + map.containsKey(targetKey));

        // b) Check if a particular value exists or not
        String targetValue = "David";
        System.out.println("Does value '" + targetValue + "' exist? " + map.containsValue(targetValue));

        // c) Use Iterator to loop through the map
        System.out.println("\nLooping through map using Iterator:");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("Department: " + entry.getKey() + " | Lead: " + entry.getValue());
        }
    }
}