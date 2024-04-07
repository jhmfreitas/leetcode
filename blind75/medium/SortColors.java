package blind75.medium;

public class SortColors {

    // Slightly less efficient solution with O(3n) complexity
    public void sortColors(int[] nums) {

        int left = 0;
        for(int i = 0; i <= 2; i++) {
            int right = left;
            while (right < nums.length) {
                if (nums[right] != i) {
                    right++;
                } else {
                    int aux = nums[left];
                    nums[left] = nums[right];
                    nums[right] = aux;
                    left++;
                    right++;
                }
            }
        }

    }


    // One pass O(N) solution
    // Dutch national flag algorithm
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int currentIndex = 0;

        while (currentIndex < right) {
            if (nums[currentIndex] == 0) {
                swap(nums, left, currentIndex);
                left++;
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                swap(nums, currentIndex, right);
                right--;
                // we don't increment the currentIndex to avoid leaving a 0 in the middle of the array
                // because we could have swapped a 0 that was at the end with a 2 in the middle
                // If we increment currentIndex we might not reach that 0 again with the i leaving it in the middle
            } else {
                currentIndex++;
            }
        }

    }

    void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
