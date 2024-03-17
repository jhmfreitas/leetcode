package blind75.easy;

import java.util.regex.Matcher;

public class DiameterOfBinaryTree {
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

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(TreeNode root, int[] maxDiameter) {
        if(root == null)
            return 0;

        int leftHeight = dfs(root.left, maxDiameter);
        int rightHeight = dfs(root.right, maxDiameter);

        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight+rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
