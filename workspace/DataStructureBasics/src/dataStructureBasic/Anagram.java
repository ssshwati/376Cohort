package dataStructureBasic;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static boolean checkAnagrams(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();

        // Update the frequency of characters in the first string
        for (char ch : str1.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        // Update the frequency of characters in the second string
        for (char ch : str2.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) - 1);
        }

        // Check if all frequencies are zero
        for (int frequency : charFrequency.values()) {
            if (frequency != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String string1 = "Listen";
        String string2 = "Silent";
        boolean result = checkAnagrams(string1, string2);
        System.out.println("Areanagrams? "+ result);
    }
}

