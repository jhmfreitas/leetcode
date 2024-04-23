package blind75.medium;

public class ContainerWithMostWater {

    // Brute force: O(N^2)
    public int maxArea(int[] height) {
        int maxSum = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxSum = Math.max(maxSum, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxSum;
    }


    // Two Pointers: O(N)
    public int maxArea(int[] height) {
        int maxSum = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                maxSum = Math.max(maxSum, height[left] * (right - left));
                left++;
            } else {
                maxSum = Math.max(maxSum, height[right] * (right - left));
                right--;
            }
        }
        return maxSum;
    }
}
