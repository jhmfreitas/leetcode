package blind75.medium;

import java.util.HashMap;

public class ContinuousSubarraySum {
    // O(N)
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    // O(N^N)
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 0)
            return false;


        HashMap<Integer, Integer> prefixSumModMap = new HashMap<>();
        prefixSumModMap.put(0, -1);

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;

            if(prefixSumModMap.containsKey(sum)) {
                if(i - prefixSumModMap.get(sum) > 1)
                    return true;
            } else {
                prefixSumModMap.put(sum, i);
            }
        }
        return false;
    }
}
