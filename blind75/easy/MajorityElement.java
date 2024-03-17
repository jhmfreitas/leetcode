package blind75.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Linear Time Complexity
    // O(K) Space Complexity, where K is the number of distinct digits in the array
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums){
            if (count.containsKey(n)){
                count.put(n, count.get(n) + 1);
            } else {
                count.put(n, 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet())
            if (entry.getValue() > nums.length/2)
                res = entry.getKey();

        return res;
    }

    // Linear Time Complexity
    // O(1) Space Complexity

    // Moore's Voting Algorithm
    // This only works because if the candidate appears more than n/2 times, its count will survive the decrements
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        for (int n : nums){
            if(count == 0) {
                candidate = n;
                count = 1;
            } else if (candidate != n) {
                count -= 1;
            } else {
                count += 1;
            }
        }

        return candidate;
    }
}
