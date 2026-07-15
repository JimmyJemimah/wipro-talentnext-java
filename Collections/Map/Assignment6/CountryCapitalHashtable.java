package Assignment6;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class CountryCapitalHashtable {
    // Hashtable is synchronized and does not allow null keys or values
    private Hashtable<String, String> M1 = new Hashtable<>();

    public Hashtable<String, String> saveCountryCapital(String CountryName, String capital) {
        M1.put(CountryName, capital);
        return M1;
    }

    public String getCapital(String CountryName) {
        return M1.get(CountryName);
    }

    public String getCountry(String capitalName) {
        for (Map.Entry<String, String> entry : M1.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(capitalName)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Hashtable<String, String> invertMap() {
        Hashtable<String, String> M2 = new Hashtable<>();
        for (Map.Entry<String, String> entry : M1.entrySet()) {
            M2.put(entry.getValue(), entry.getKey());
        }
        return M2;
    }

    public ArrayList<String> toCountryList() {
        return new ArrayList<>(M1.keySet());
    }

    public static void main(String[] args) {
        CountryCapitalHashtable tableObj = new CountryCapitalHashtable();
        
        tableObj.saveCountryCapital("India", "Delhi");
        tableObj.saveCountryCapital("Japan", "Tokyo");

        System.out.println("Hashtable Summary Output:");
        System.out.println(tableObj.saveCountryCapital("France", "Paris"));

        System.out.println("\nCapital of India: " + tableObj.getCapital("India"));
        System.out.println("Country with Capital Paris: " + tableObj.getCountry("Paris"));
    }
}