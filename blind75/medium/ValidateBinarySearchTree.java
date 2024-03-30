package blind75.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        return dfsBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfsBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if(!(min < root.val && root.val < max))
            return false;

        return dfsBST(root.left, min, root.val) && dfsBST(root.right, root.val, max);
    }
}
