package blind75.medium;

public class MaximumProductSubarray {
    // Dynamic programming approach
    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            if(num == 0) {
                maxProduct = 1;
                minProduct = 1;
                res = Math.max(res, 0); // Check if zero is the maximum product itself
                continue;
            }

            int tmp = num * maxProduct;
            maxProduct = Math.max(Math.max(tmp, num * minProduct), num); // [-1, 8] example to why we need the n
            minProduct = Math.min(Math.min(tmp, num * minProduct), num); // [-1, -8] example to why we need the n
            res = Math.max(res, maxProduct);
        }

        return res;
    }

    // Prefix and suffix sum
    public int maxProduct(int[] nums) {
        int pf1 = nums[0]; // Initialize pf1 to first element
        int max1 = pf1;
        int pf2 = nums[nums.length - 1]; // Initialize pf2 to last element
        int max2 = pf2;

        for (int i = 1; i < nums.length; i++) {
            pf1 = (pf1 == 0 ? 1 : pf1) * nums[i]; // Reset if encountering zero
            max1 = Math.max(max1, pf1);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            pf2 = (pf2 == 0 ? 1 : pf2) * nums[i]; // Reset if encountering zero
            max2 = Math.max(max2, pf2);
        }

        return Math.max(max1, max2);
    }
}
