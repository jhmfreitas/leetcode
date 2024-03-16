package blind75.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;


public class ValidAnagram {

    // Efficient solution
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    // Naive Solution
    public boolean isAnagram(String s, String t) {
        int wordLength = s.length();
        if(wordLength != t.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < wordLength; i++) {
            char c = s.charAt(i);

            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        for (int i = 0; i< wordLength; i++) {
            char c = s.charAt(i);

            if (!count.containsKey(c)) {
                return false;
            }

            if (count.get(c) == 0) {
                return false;
            }

            count.put(c, count.get(c) - 1);
        }

        return true;
    }

}
