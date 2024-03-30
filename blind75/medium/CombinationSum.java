package blind75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n^target/min(candidates)) where min(candidates) means the smallest number in candidates because the smaller
 * it is the more combinations are generated
 *
 * Space Complexity: O(target/min(candidates)) as each candidate combination is at most length target/min(candidates)
 * corresponding to the maximum height of the state-space tree.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfsCombinationFinder(candidates, 0, target, new ArrayList<>(),  res, 0);
        return res;
    }

    private void dfsCombinationFinder(int[] candidates, int currentSum, int target, List<Integer> currentPath,  List<List<Integer>> res, int start) {
        if (currentSum == target) {
            res.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int sum = currentSum + candidates[i];
            if (sum <= target) {
                currentPath.add(candidates[i]);
                dfsCombinationFinder(candidates, sum, target, currentPath, res, i);
                currentPath.remove(currentPath.size() - 1);
            } else {
                break;
            }
        }
    }
}
