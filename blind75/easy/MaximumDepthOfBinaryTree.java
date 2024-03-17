package blind75.easy;

/**
 * Time Complexity: O(n)
 * There are n nodes and n - 1 edges in a tree so if we traverse each once then the total traversal is O(2n - 1)
 * which is O(n).
 *
 * Space Complexity: O(h)
 * The call stack uses at most O(h) memory where h is the height of the tree, which is worst case O(n) when the tree
 * is skewed (each node has one or no children).
 *
 */
public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pathLength) {
        if (root == null){
            return pathLength;
        }

        int leftHeight = dfs(root.left, pathLength + 1);
        int rightHeight = dfs(root.right, pathLength + 1);

        return Math.max(leftHeight, rightHeight);
    }

}
