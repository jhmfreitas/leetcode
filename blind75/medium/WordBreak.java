package blind75.medium;

import java.util.List;

/**
 *
 * Time Complexity: O(N*N*M) -> go through every starting position * each word in dic * comparing word with substring
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i+s.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }

                if (dp[i])
                    break;
            }
        }

        return dp[0];
    }

}
