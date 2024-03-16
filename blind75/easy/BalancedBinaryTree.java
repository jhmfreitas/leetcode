package blind75.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBinaryTree {
    
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

    public boolean isBalanced(TreeNode root) {
        return root != null & dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = dfsHeight(root);
        int rightHeight = dfsHeight(root);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) >= 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
