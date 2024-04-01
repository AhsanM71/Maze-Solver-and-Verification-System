package ca.mcmaster.se2aa4.mazerunner.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PathFormatter {

    public String factorizedForm(List<String> path) {
        // Adding null to the list to act as the stopping condition for the for loop and
        // to ensure the String get's formatted correctly
        path.add("null");
        String conv = "";
        int count = 1;
        for (int i = 0; i < path.size() - 1; i++) {
            // Checking if the neighbouring characters are the same
            if (path.get(i).equals(path.get(i + 1))) {
                // count the number of neighbouring characters that are the same
                count++;
                // Else condition get's executed if the neighbouring characters aren't the same
            } else {
                // If condition checks if theres only one occurance of that specific character
                // then only append that char to the factorized form String
                if (count == 1) {
                    conv += path.get(i) + " ";
                    // Else if there are a number of occurances of a specific char then append the
                    // number of occurances with the char to the factorized form String
                } else {
                    conv += count + path.get(i) + " ";
                }
                count = 1;
            }
        }
        return conv.replaceAll("\\s+$", "");
    }

    public List<String> strToList(String path) {
        List<String> p = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            p.add(path.charAt(i) + "");
        }
        return p;
    }
}
