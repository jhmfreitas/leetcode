package blind75.hard;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] targetLetterCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            targetLetterCount[t.charAt(i)]++;
        }

        int minLength = Integer.MAX_VALUE;
        int minWindowStart = -1;
        int requiredChars = t.length();
        int formedchars = 0;
        int left = 0;

        int[] windowLetterCount = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowLetterCount[rightChar]++;

            if (windowLetterCount[rightChar] <= targetLetterCount[rightChar]) {
                formedchars++;
            }

            while (formedchars == requiredChars) {
                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    minWindowStart = left;
                }

                char leftChar = s.charAt(left);
                if (windowLetterCount[leftChar] <= targetLetterCount[leftChar]) {
                    formedchars--;
                }

                windowLetterCount[leftChar]--;
                left++;
            }
        }

        return minWindowStart < 0 ? "" : s.substring(minWindowStart, minWindowStart + minLength);
    }
}
