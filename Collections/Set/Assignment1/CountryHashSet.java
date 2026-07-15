package Assignment1;

import java.util.HashSet;
import java.util.Iterator;

public class CountryHashSet {
    private HashSet<String> H1 = new HashSet<>();

    public HashSet<String> saveCountryNames(String CountryName) {
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
        CountryHashSet countrySet = new CountryHashSet();
        
        countrySet.saveCountryNames("India");
        countrySet.saveCountryNames("USA");
        countrySet.saveCountryNames("Japan");

        System.out.println("Finding 'India': " + countrySet.getCountry("India"));
        System.out.println("Finding 'Germany': " + countrySet.getCountry("Germany"));
    }
}