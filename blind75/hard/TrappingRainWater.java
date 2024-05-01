package blind75.hard;

public class TrappingRainWater {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int trap(int[] height) {
        int trappedWater = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            // In the solution below we only care about the minimum height because that is the bottleneck
            // That is why we don't need to store the whole array, we just need to check the heights as we go
            if (height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += rightMax - height[right];
            }
        }
        return trappedWater;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int trap(int[] height) {
        int trappedWater = 0;

        int left = 0;
        int right = height.length - 1;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[left];
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[right];

        int[] minWater = new int[height.length];
        for (int i = 1, j = height.length - 2; i < height.length; i++,j--) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[j] = Math.max(height[j], rightMax[j + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int val = Math.min(leftMax[i], rightMax[i]) - height[i];
            minWater[i] = Math.max(val, 0);
            trappedWater += minWater[i];
        }
        return trappedWater;
    }

    // Works but time limit exceeded
    // Time complexity: O(maxHeight * N)
    public int trap(int[] height) {
        int trappedWater = 0;

        int maxHeight = 0;
        for (int i = 0; i < height.length - 1; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
        }

        for (int i = 0; i < maxHeight; i++) {
            int left = 0;
            int right;
            while (left < height.length) {
                while (left < height.length && height[left] == 0) {
                    left++;
                }

                right = left + 1;
                while (right < height.length && height[right] == 0) {
                    right++;
                }

                if (right < height.length) {
                    trappedWater += right - left - 1;
                }
                left = right;
            }

            for (int k = 0; k < height.length; k++) {
                if (height[k] >= 1)
                    height[k]--;
            }
        }

        return trappedWater;
    }
}
