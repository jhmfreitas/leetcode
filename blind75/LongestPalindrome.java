package blind75;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // ASCII characters values go from 0 to 127
        int[] charCount = new int[128];
        for (char c : s.toCharArray())
            charCount[c]++;

        int longestPalindromeLength = 0;
        for (int count : charCount){
            // If the count is even we can add it to the length, if it is odd it depends if the length is even or not
            // Therefore we subtract the remainder of the division by 2
            longestPalindromeLength += count - (count % 2);
            if(longestPalindromeLength % 2 == 0 && count % 2 == 1)
                longestPalindromeLength++;
        }
        return longestPalindromeLength;
    }
}
