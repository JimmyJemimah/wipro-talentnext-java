package Assignment4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContactList {
    public static void main(String[] args) {
        // String for Name (Key), Integer for Phone Number (Value)
        HashMap<String, Integer> contactList = new HashMap<>();

        contactList.put("Amit", 987654321);
        contactList.put("Priya", 876543210);
        contactList.put("Rahul", 765432109);

        // a) Check if a particular key exists or not
        String searchKey = "Priya";
        System.out.println("Does contact '" + searchKey + "' exist? " + contactList.containsKey(searchKey));

        // b) Check if a particular value exists or not
        Integer searchValue = 123456789;
        System.out.println("Does number '" + searchValue + "' exist? " + contactList.containsValue(searchValue));

        // c) Use Iterator to loop through the map
        System.out.println("\nLooping through Contact List using Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = contactList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Name: " + entry.getKey() + " | Phone: " + entry.getValue());
        }
    }
}