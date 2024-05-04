package blind75.hard;

import java.util.List;
import java.util.Stack;

public class LargestRectangleInHistogram {

    // No stack solution that uses last seen lower rectangle
    // Time Complexity: O(N)
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    // Monotonic stack solution
    // Time complexity: O(N)
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<List<Integer>> stack = new Stack<>(); // (startIndex, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().get(1) > heights[i]) {
                List<Integer> pair = stack.pop();
                maxArea = Math.max(maxArea, pair.get(1) * (i - pair.get(0)));
                start = pair.get(0);
            }
            stack.add(List.of(start, heights[i]));
        }

        // Calculate remaining rectangles area
        // The queue will have elements if at some point it the heights increase constantly until the end of the array
        while (!stack.isEmpty()) {
            List<Integer> pair = stack.pop();
            maxArea = Math.max(maxArea, pair.get(1) * (heights.length - pair.get(0)));
        }

        return maxArea;
    }

    // Works but time limit exceeded
    // Time Complexity: O(N^2)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                maxArea = Math.max(maxArea, getMinHeight(heights, i, j) * (j - i + 1));
            }
        }
        return maxArea;
    }

    public int getMinHeight(int[] heights, int l, int r) {
        int minHeight = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            minHeight = Math.min(minHeight, heights[i]);
        }
        return minHeight;
    }
}
