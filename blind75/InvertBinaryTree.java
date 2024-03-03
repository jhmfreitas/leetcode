package blind75;

public class InvertBinaryTree {
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

    // Inverts binary tree in-place
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }



    // Creates inverted tree allocating memory for new tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        return new TreeNode(root.val, invertTree(root.right),invertTree( root.left));
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;

        root.left = invertTree(rightSubtree);
        root.right = invertTree(leftSubtree);

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode node = new TreeNode();
        node.left = invertTree(node.right);
        node.val = root.val;
        node.right = invertTree(node.left);
        return node;
    }
}
