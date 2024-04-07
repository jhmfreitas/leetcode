package blind75.medium;

import java.util.Arrays;

/*
Time Complexity: O(N*target)
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;

        for(int i = 1; i <= nums.length; i++) {
            for (int sum = 0; sum <= target; sum++) {
                if(sum < nums[i - 1] ) {
                    dp[i][sum] = dp[i - 1][sum];
                } else {
                    dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }

    // Memory Optimization
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[2][target + 1];
        dp[0][0] = true;

        for(int i = 1; i <= nums.length; i++) {
            for (int sum = 0; sum <= target; sum++) {
                if(sum < nums[i - 1] ) {
                    dp[1][sum] = dp[0][sum];
                } else {
                    dp[1][sum] = dp[0][sum] || dp[0][sum - nums[i - 1]];
                }
            }

            for (int k = 0; k <= target; k++) {
                dp[0][k] = dp[1][k];
                dp[1][k] = false;
            }
        }

        return dp[0][target];
    }
}
