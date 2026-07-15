package Assignment4;

import java.util.Iterator;
import java.util.TreeSet;

public class CountryTreeSet {
    private TreeSet<String> H1 = new TreeSet<>();

    public TreeSet<String> saveCountryNames(String CountryName) {
        H1.add(CountryName);
        return H1;
    }

    public String getCountry(String CountryName) {
        Iterator<String> it = H1.iterator();
        while (it.hasNext()) {
            String current = it.next();
            if (current.equalsIgnoreCase(CountryName)) {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CountryTreeSet countrySet = new CountryTreeSet();
        
        countrySet.saveCountryNames("India");
        countrySet.saveCountryNames("USA");
        countrySet.saveCountryNames("Japan");

        System.out.println("TreeSet Output (Sorted): " + countrySet.saveCountryNames("UK"));
        System.out.println("Finding 'Japan': " + countrySet.getCountry("Japan"));
    }
}