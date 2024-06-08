package blind75.easy;

public class MissingNumber {

    // Using expected sum
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;

        // Calculate the expected sum of the first n natural numbers
        int expectedSum = n * (n + 1) / 2;
        for (int num : nums) {
            sum += num;
        }

        return expectedSum - sum;
    }

    // Using arrays
    public int missingNumber(int[] nums) {
        int[] n = new int[nums.length + 1];

        for (int num : nums) {
            n[num] = 1;
        }

        for(int i = 0; i < nums.length+1; i++) {
            if(n[i] == 0)
                return i;
        }

        return -1;
    }


}
