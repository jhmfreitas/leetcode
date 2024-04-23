package blind75.medium;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();

        if (n == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] degrees = new int[n];
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            adjList[nodeA].add(nodeB);
            adjList[nodeB].add(nodeA);

            degrees[nodeA]++;
            degrees[nodeB]++;
        }

        // Queue for holding the leaves nodes
        Queue<Integer> leavesQueue = new LinkedList<>();

        // Add initial leaves to queue - those are nodes with degree 1
        // The key is to understand that the nodes from the center are the ones we are looking for
        // If we pick nodes from the leafs it will take more to reach the other side
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                leavesQueue.offer(i);
            }
        }


        // Process leaves until there are potentially 2 or less nodes left
        while (!leavesQueue.isEmpty()) {
            // Clear the previous result
            minHeightTrees.clear();

            // Number of leaves at the current level
            int leavesCount = leavesQueue.size();

            // Process each leaf node
            for (int i = 0; i < leavesCount; i++) {
                int leafNode = leavesQueue.poll();

                // Add the leaf node to the result
                minHeightTrees.add(leafNode);

                // Visit all neighboring nodes
                for (int neighbor : adjList[leafNode]) {
                    // Decrease the degree as we are removing the leaf node
                    degrees[neighbor]--;
                    // If this makes the neighbor a new leaf, add it to queue
                    if (degrees[neighbor] == 1) {
                        leavesQueue.offer(neighbor);
                    }
                }
            }
        }

        // Returns the list of rooted trees with minimal height
        return minHeightTrees;
    }

}
