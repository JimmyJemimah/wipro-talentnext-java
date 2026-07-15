package Assignment5;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CountryCapitalTreeMap {
    // TreeMap automatically stores keys in sorted natural alphabetical order
    private TreeMap<String, String> M1 = new TreeMap<>();

    public TreeMap<String, String> saveCountryCapital(String CountryName, String capital) {
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

    public TreeMap<String, String> invertMap() {
        TreeMap<String, String> M2 = new TreeMap<>();
        for (Map.Entry<String, String> entry : M1.entrySet()) {
            M2.put(entry.getValue(), entry.getKey());
        }
        return M2;
    }

    public ArrayList<String> toCountryList() {
        return new ArrayList<>(M1.keySet());
    }

    public static void main(String[] args) {
        CountryCapitalTreeMap treeMapObj = new CountryCapitalTreeMap();
        
        treeMapObj.saveCountryCapital("Japan", "Tokyo");
        treeMapObj.saveCountryCapital("India", "Delhi");
        treeMapObj.saveCountryCapital("USA", "Washington");

        System.out.println("TreeMap Output (Sorted by Country Key):");
        System.out.println(treeMapObj.saveCountryCapital("UK", "London"));

        System.out.println("\nCapital of Japan: " + treeMapObj.getCapital("Japan"));
        System.out.println("Country with Capital Delhi: " + treeMapObj.getCountry("Delhi"));
    }
}