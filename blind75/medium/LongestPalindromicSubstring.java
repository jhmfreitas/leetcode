package blind75.medium;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >=i; j--) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring) && substring.length() > longestPalindrome.length()) {
                    longestPalindrome = substring;
                }
            }
        }

        return longestPalindrome;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }

        return left > right;
    }


    // O(N^2) Solution
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longestPalindrome = "";
        int longestPalindromeLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longestPalindromeLength) {
                    longestPalindromeLength = len;
                    longestPalindrome = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            // Even length palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longestPalindromeLength) {
                    longestPalindromeLength = len;
                    longestPalindrome = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return longestPalindrome;
    }
}
