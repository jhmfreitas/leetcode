package blind75.easy;

public class SubtreeOfAnotherTree {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true; // An empty tree is always a subtree
        if (root == null) return false; // An empty tree can't contain a non-empty subtree
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return false; // Base case for recursion
        if (isIdentical(root, subRoot)) return true;
        return dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    public boolean isIdentical(TreeNode t, TreeNode r) {
        if (t == null && r == null) return true; // Both trees are empty
        if (t == null || r == null) return false; // One tree is empty, the other is not

        if (t.val != r.val ) return false;

        return isIdentical(t.left, r.left) && isIdentical(t.right, r.right);
    }
}
