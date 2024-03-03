package blind75;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int res = -1;
        // Assumes non rotated with these defaults
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            // When middle element is on the non-rotated portion of the array
            if(nums[0] <= nums[mid]) {

                if (nums[0] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // When middle element is on the rotated portion of the array
            else {
                if (nums[mid] <= target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if(nums[mid] == target) {
                res = mid;
            }

        }
        return res;
    }

}
