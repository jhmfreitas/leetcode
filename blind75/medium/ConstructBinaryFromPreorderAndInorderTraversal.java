package blind75.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

public class ConstructBinaryFromPreorderAndInorderTraversal {

    private int[] preorderTraversal; // Array to hold the preorder traversal of the tree
    private Map<Integer, Integer> inorderIndices = new HashMap<>(); // Map to hold the indices of values in inorder traversal

    // Builds the binary tree given preorder and inorder traversal arrays
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length; // The number of nodes in the tree
        this.preorderTraversal = preorder; // Assigning preorder traversal array to the class variable for global access in this context

        // Mapping each value from inorder array to its index for quick lookup
        for (int i = 0; i < n; ++i) {
            inorderIndices.put(inorder[i], i);
        }

        return buildTreeRecursive(0, 0, n);
    }

    private TreeNode buildTreeRecursive(int preorderStart, int inorderStart, int size) {
        if (size <= 0) { // Base case: if there are no elements to consider, return null
            return null;
        }

        int rootVal = preorderTraversal[preorderStart];
        int inorderRootIndex = inorderIndices.get(rootVal);
        int leftSubtreeSize = inorderRootIndex - inorderStart;

        TreeNode left = buildTreeRecursive(preorderStart + 1, inorderStart, leftSubtreeSize);
        // Need to move past the left subtree in the preorder array, hence "preorderStart + 1 + leftSubtreeSize"
        TreeNode right = buildTreeRecursive(preorderStart + 1 + leftSubtreeSize, inorderRootIndex + 1, size - 1 - leftSubtreeSize);
        // Creating the current root node with computed left and right subtrees
        return new TreeNode(rootVal, left, right);
    }
}
