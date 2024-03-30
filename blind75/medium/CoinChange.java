package blind75.medium;

import java.util.Arrays;

/**
 *
 * Time Complexity: O(amount * coins.size())
 * Space Complexity: O(amount)
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (a - coin >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a -coin]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
