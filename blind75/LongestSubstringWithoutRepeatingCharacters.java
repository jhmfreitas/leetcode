package blind75;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int stringSize = s.length();
        if(stringSize == 0)
            return 0;

        Map<Character, Boolean> letterCount = new HashMap<>();
        int start = 0, end = 0;
        int maxCount = 0;
        int count = 0;
        while(end < stringSize) {
            char c = s.charAt(end);
            if (letterCount.containsKey(c) && letterCount.get(c)) {
                letterCount.put(s.charAt(start), false);
                start++;
                count--;
            } else {
                letterCount.put(c, true);
                count++;
                maxCount = Math.max(count, maxCount);
                end++;
            }
        }

        return maxCount;
    }
}
