package blind75.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * If the BST is modified often and you need to find the kth smallest element frequently, you can optimize the solution
 * by maintaining additional information in each node of the BST. One common approach is to store the number of nodes in
 * the subtree rooted at each node. This allows you to quickly determine the rank of any node relative to the entire BST.
 *
 */
public class KthSmallestElementInBst {

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

    // Iterative solution
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }

        return 0;
    }


    // Recursive solution
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallestDfs(root, list);
        return list.get(k - 1);
    }

    private void kthSmallestDfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        kthSmallestDfs(root.left, list);
        list.add(root.val);
        kthSmallestDfs(root.right, list);
    }

}
