package Assignment3;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties statesCapitals = new Properties();

        // Storing States of India and their Capitals
        statesCapitals.setProperty("Tamil Nadu", "Chennai");
        statesCapitals.setProperty("Karnataka", "Bengaluru");
        statesCapitals.setProperty("Maharashtra", "Mumbai");
        statesCapitals.setProperty("Telangana", "Hyderabad");

        // Use an Iterator to list all the elements stored in the Properties
        Set<String> states = statesCapitals.stringPropertyNames();
        Iterator<String> iterator = states.iterator();

        System.out.println("Listing all elements using Iterator:");
        while (iterator.hasNext()) {
            String state = iterator.next();
            String capital = statesCapitals.getProperty(state);
            System.out.println("State: " + state + " -> Capital: " + capital);
        }
    }
}