package blind75;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                res = mid;
                break;
            }

        }
        return res;
    }
}
