package blind75.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity: O(N*2^N)
 *
 * For each number you choose to include it or not
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfsCombinations(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfsCombinations(int[] nums, List<List<Integer>> res, List<Integer> combination, int startingIndex) {
        res.add(new ArrayList<>(combination));
        for (int i = startingIndex; i < nums.length; i++) {
            combination.add(nums[i]);
            dfsCombinations(nums, res, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
