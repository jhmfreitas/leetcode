package blind75.medium;

import java.util.*;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        int windowSize = p.length();
        // Count the frequency of characters in the pattern
        int[] patternCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            patternCount[p.charAt(i) - 'a']++;
        }

        // Initialize character frequency counter for window in 's'
        int[] windowCount = new int[26];
        // Initialize the window with the first (patternLength - 1) characters
        for (int i = 0; i < p.length() - 1; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = p.length() - 1; i < s.length(); i++) {
            windowCount[s.charAt(i) - 'a']++;

            if (Arrays.equals(patternCount, windowCount))
                res.add(i - windowSize + 1);

            windowCount[s.charAt(i - windowSize + 1) - 'a']--;
        }

        return res;
    }
}
