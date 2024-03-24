package blind75.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        Map<Integer, Node> visited = new HashMap<>();
        return dfsClone(node, visited);
    }

    private Node dfsClone(Node node, Map<Integer, Node> visited) {
        if (node == null )
            return null;

        if(visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        Node nodeCopy = new Node(node.val);
        visited.put(nodeCopy.val, nodeCopy);

        List<Node> childCopies = new ArrayList<>();
        for (Node child : node.neighbors) {
            childCopies.add(dfsClone(child, visited));
        }

        nodeCopy.neighbors = childCopies;

        return nodeCopy;
    }
}
