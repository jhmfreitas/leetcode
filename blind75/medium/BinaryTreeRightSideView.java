package blind75.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();

            // Only adds the rightmost element
            res.add( deque.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();

                if (node.right != null) {
                    deque.offer(node.right);
                }

                if (node.left != null) {
                    deque.offer(node.left);
                }
            }
        }
        return res;
    }

}
