package blind75.hard;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitJobScheduling {

    // Version 1: Knapsack like problem because we choose to pick or not pick jobs
    // This solution is not accepted because of time limit exceeded
    // Time Complexity: O(N^2)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < endTime.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        // Sort jobs based on their start times in ascending order
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        return dfs(jobs, 0);
    }

    public int dfs(int[][] jobs, int index) {
        if (index == jobs.length)
            return 0;

        // don't include job
        int res = dfs(jobs, index + 1);

        // include job
        int j = index + 1;

        // The O(N^2) complexity comes from here
        while (j < jobs.length && jobs[j][0] < jobs[index][1]) {
            j++;
        }

        res = Math.max(res, jobs[index][2]  + dfs(jobs, j));
        return res;
    }

    // Version 2: Memoization
    // This solution is accepted in leetcode but is slow due to the O(N^2) complexity
    // Time Complexity: O(N^2)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < endTime.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        int[] dp = new int[jobs.length];
        Arrays.fill(dp, -1);
        // Sort jobs based on their start times in ascending order
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        return dfs(jobs, 0, dp);
    }

    public int dfs(int[][] jobs, int index, int[] dp) {
        if (index == jobs.length)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        // don't include job
        int res = dfs(jobs, index + 1, dp);

        // include job
        int j = index + 1;

        // The O(N^2) complexity comes from here because we are doing dfs * cycle through all elements
        while (j < jobs.length && jobs[j][0] < jobs[index][1]) {
            j++;
        }

        res = Math.max(res, jobs[index][2]  + dfs(jobs, j, dp));
        dp[index] = res;
        return res;
    }

    // Version 3: Memoization with binary search
    // This solution is accepted in leetcode and is the fastest
    // Time Complexity: O(NlogN)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        int[] dp = new int[jobs.length];
        for (int i = 0; i < endTime.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
            dp[i] = -1;
        }

        // Sort jobs based on their start times in ascending order
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        return dfs(jobs, 0, dp);
    }

    public int dfs(int[][] jobs, int index, int[] dp) {
        if (index == jobs.length)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        // don't include job
        int res = dfs(jobs, index + 1, dp);

        // include job
        int j = index + 1;

        // Time Complexity: O(logN)
        j = findNextJob(jobs, index, j);

        dp[index] = Math.max(res, jobs[index][2]  + dfs(jobs, j, dp));
        return dp[index];
    }

    private static int findNextJob(int[][] jobs, int index, int j) {
        int left = j, right = jobs.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(jobs[mid][0] < jobs[index][1]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left;
    }
}
