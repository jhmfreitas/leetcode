package blind75.hard;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Uses BFS to serialize and deserialize the binary tree

    // It is also possible to do it with a DFS + pre order traversal
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            Queue<TreeNode> stack = new LinkedList<>();
            stack.offer(root);

            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                TreeNode node = stack.poll();
                if (node == null) {
                    res.append("#").append(" ");
                    continue;
                }

                res.append(node.val).append(" ");
                stack.offer(node.left);
                stack.offer(node.right);
            }
            return res.toString().trim();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty() || data.equals("#")) {
                return null;
            }

            String[] tokens = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));

            Queue<TreeNode> stack = new LinkedList<>();
            stack.add(root);

            for (int i = 1; i < tokens.length; i++) {
                TreeNode node = stack.poll();

                if (!tokens[i].equals("#")) {
                    int leftVal = Integer.parseInt(tokens[i]);
                    node.left = new TreeNode(leftVal);
                    stack.add(node.left);
                }

                if (!tokens[++i].equals("#")) {
                    int rightVal = Integer.parseInt(tokens[i]);
                    node.right = new TreeNode(rightVal);
                    stack.add(node.right);
                }
            }
            return root;
        }
    }
}
