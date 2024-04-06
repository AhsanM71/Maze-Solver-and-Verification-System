package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private String str;

    public Path(String str) {
        this.str = str;
    }

    public String factorizedToCanonical() {
        String path = str.trim().replaceAll("\\s", "");
        StringBuilder sb = new StringBuilder();
        if (path.length() == 1) {
            return path;
        }
        for (int i = 0; i < path.length() - 1; i++) {
            char c = path.charAt(i);
            char nextChar = path.charAt(i + 1);

            // If condition checks if the digit in front of character is double digits
            if (Character.isDigit(c) && Character.isDigit(nextChar)) {
                // Retrieving the numerical value of the double digit
                int n = Character.getNumericValue(c + nextChar);
                // Retrieving the character
                char getChar = path.charAt(i + 2);
                // Appending the character getChar, n times to the String newStr
                sb.append(Character.toString(getChar).repeat(n));
                // Skipping to the next digit sequence in the String conv
                i += 2;
                // Else if condition checks if the digit in fron of character is a digit
            } else if (Character.isDigit(c)) {
                // Retrieving the numerical value of the digit
                int num = Character.getNumericValue(c);
                char c2 = path.charAt(i + 1);
                // Appending the character getChar, n times to the String newStr
                sb.append(Character.toString(c2).repeat(num));
                // Skipping to the next digit sequence in the String conv
                i += 1;
                // Else condition get's executed if there are no digits in front of the
                // character (Ex: R)
            } else {
                // Appending the single character c to the String newStr
                sb.append(c);
            }
        }
        // if condition test's an edge case where if the last character in the String
        // conv doesn't have a number before it then execute the condition, this edge
        // case is cause by the iterations of i from the for loop
        if (!Character.isDigit(path.charAt(path.length() - 2))) {
            // Append the last character to the String.
            sb.append(path.charAt(path.length() - 1));
        }
        return sb.toString();
    }

    public String canonicalToFactorized() {
        // Adding null to the list to act as the stopping condition for the for loop and
        // to ensure the String get's formatted correctly
        List<String> path = strToList(str);
        path.add("null");
        StringBuilder sb = new StringBuilder();
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
                    sb.append(path.get(i) + " ");
                    // Else if there are a number of occurances of a specific char then append the
                    // number of occurances with the char to the factorized form String
                } else {
                    sb.append(count + path.get(i) + " ");
                }
                count = 1;
            }
        }
        return sb.toString();
    }

    public List<String> strToList(String path) {
        List<String> p = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            p.add(path.charAt(i) + "");
        }
        return p;
    }

    public String getPath() {
        return str;
    }

    public String listToStr(List<String> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
        }
        return sb.toString();
    }

    public void setPath(String path) {
        str = path;
    }
}
