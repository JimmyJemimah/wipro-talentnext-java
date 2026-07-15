package Assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountryCapitalMap {
    private HashMap<String, String> M1 = new HashMap<>();

    // 1. Save country and capital
    public HashMap<String, String> saveCountryCapital(String CountryName, String capital) {
        M1.put(CountryName, capital);
        return M1;
    }

    // 2. Fetch capital given country
    public String getCapital(String CountryName) {
        return M1.get(CountryName);
    }

    // 3. Fetch country given capital
    public String getCountry(String capitalName) {
        for (Map.Entry<String, String> entry : M1.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(capitalName)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // 4. Invert map: Capital as Key, Country as Value
    public HashMap<String, String> invertMap() {
        HashMap<String, String> M2 = new HashMap<>();
        for (Map.Entry<String, String> entry : M1.entrySet()) {
            M2.put(entry.getValue(), entry.getKey());
        }
        return M2;
    }

    // 5. Get ArrayList of all Country names (keys)
    public ArrayList<String> toCountryList() {
        return new ArrayList<>(M1.keySet());
    }

    public static void main(String[] args) {
        CountryCapitalMap mapObj = new CountryCapitalMap();
        
        mapObj.saveCountryCapital("India", "Delhi");
        mapObj.saveCountryCapital("Japan", "Tokyo");

        System.out.println("Capital of India: " + mapObj.getCapital("India"));
        System.out.println("Country with Capital Tokyo: " + mapObj.getCountry("Tokyo"));
        
        System.out.println("\nInverted Map (Capital -> Country):");
        System.out.println(mapObj.invertMap());

        System.out.println("\nCountry List from keys:");
        System.out.println(mapObj.toCountryList());
    }
}