package blind75.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Matrix01 {

    int[] deltaRow = new int[]{0,1,0,-1};
    int[] deltaColumn = new int[]{-1,0,1,0};

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] distances = new int[rows][cols];

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    distances[i][j] = 0;
                } else {
                    // Initialize the distance matrix with -1 to mark as not processed
                    distances[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int currentRow = position[0];
            int currentCol = position[1];

            // Iterate over the four possible neighbors of the current cell.
            for (int k = 0; k < 4; k++) {
                int newRow = currentRow + deltaRow[k];
                int newCol = currentCol + deltaColumn[k];

                // Check if the new cell is within bounds and hasn't been visited yet.
                if( 0 <= newRow && newRow < mat.length && 0 <= newCol && newCol < mat[0].length && distances[newRow][newCol] == -1){
                    // Update the distance matrix with the distance from the nearest 0.
                    distances[newRow][newCol] = distances[currentRow][currentCol] + 1;
                    // Add the new cell to the queue to continue the BFS.
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return distances;
    }
}
