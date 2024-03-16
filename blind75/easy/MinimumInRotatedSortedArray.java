package blind75.easy;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] <= nums[nums.length - 1]) {
                min = nums[mid];
                right--;
            } else {
                left++;
            }
        }

        return min;
    }
}
