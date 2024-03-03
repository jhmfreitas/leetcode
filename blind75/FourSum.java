package blind75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {
    private List<List<Integer>> res = new ArrayList<>();
    private long[] sortedNumbers; // Using long to avoid integer overflow

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.sortedNumbers = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.sortedNumbers[i] = nums[i];
        }
        List<Integer> combination = new ArrayList<>();
        kSum(4, 0, target, combination);
        return res;
    }

    private void kSum(int k, int start, long target, List<Integer> combination) {
        if (k != 2) {
            for (int i = start; i < this.sortedNumbers.length - k + 1; i++) {
                if (i > start && this.sortedNumbers[i] == this.sortedNumbers[i - 1])
                    continue;
                List<Integer> newCombination = new ArrayList<>(combination);
                newCombination.add((int)this.sortedNumbers[i]);
                kSum(k - 1, i + 1, target - this.sortedNumbers[i], newCombination); // Increment start by i
            }
            return;
        }

        // blind75.TwoSum II problem
        int left = start;
        int right = this.sortedNumbers.length - 1;
        while (left < right) {
            long sum = this.sortedNumbers[left] + this.sortedNumbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> newCombination = new ArrayList<>(combination);
                newCombination.add((int)this.sortedNumbers[left]);
                newCombination.add((int)this.sortedNumbers[right]);
                res.add(newCombination);
                left++;
                right--;
                // Skip duplicate numbers
                while (left < right && this.sortedNumbers[left] == this.sortedNumbers[left - 1]) {
                    left++;
                }
                while (left < right && this.sortedNumbers[right] == this.sortedNumbers[right + 1]) {
                    right--;
                }
            }
        }
    }
}
