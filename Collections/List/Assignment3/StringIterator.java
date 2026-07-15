package Assignment3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringIterator {
    public static void printAll(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("Kotlin");

        System.out.println("Iterating String ArrayList:");
        printAll(list);
    }
}