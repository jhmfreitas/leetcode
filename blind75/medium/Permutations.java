package blind75.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */
public class Permutations {

    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        visited = new boolean[nums.length];
        dfsPermutationFinder(nums, new ArrayList<>(), res);
        return res;
    }

    private void dfsPermutationFinder(int[] nums, ArrayList<Integer> currentPath, List<List<Integer>> res) {
        if (currentPath.size() == nums.length) {
            res.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) { // equivalent to !currentPath.contains(nums[i]) but more efficient
                visited[i] = true;
                currentPath.add(nums[i]);
                dfsPermutationFinder(nums, currentPath, res);
                currentPath.remove(currentPath.size() - 1);
                visited[i] = false;
            }
        }
    }
}
