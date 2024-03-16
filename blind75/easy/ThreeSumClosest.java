package blind75.easy;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
 * closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Time Complexity: O(N^2)
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // O(NlogN)
        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return target;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }

                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
            }

        }
        return closest;
    }
}
