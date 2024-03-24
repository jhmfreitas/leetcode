package blind75.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Map<Character, Integer> lastIndexOfChar = new HashMap<>();
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (lastIndexOfChar.containsKey(c)){
                startIndex = Math.max(startIndex, lastIndexOfChar.get(c) + 1);
            }
            lastIndexOfChar.put(c, i);
            max = Math.max(max, i - startIndex + 1);
        }

        return max;
    }

    // Alternative
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int left = 0;
        int longest = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            while (charCount.get(c) > 1) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

}
