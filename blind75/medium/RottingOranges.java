package blind75.medium;

import java.util.ArrayDeque;
import java.util.List;

public class RottingOranges {

    int[] deltaRow = new int[] {0,-1,0,1};
    int[] deltaCol = new int[] {-1,0,1,0};

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        ArrayDeque<int[]> deque = new ArrayDeque();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutesToRot = 0;
        while (!deque.isEmpty() && freshOranges > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] parent = deque.poll();
                for (int j = 0; j < 4; j++) {
                    int newRow = parent[0] + deltaRow[j];
                    int newCol = parent[1] + deltaCol[j];
                    if(0 <= newRow && newRow < m && 0 <= newCol && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        deque.offer(new int[] {newRow, newCol});
                        freshOranges--;
                    }
                }
            }
            minutesToRot++;
        }

        return freshOranges > 0 ? - 1 : minutesToRot;
    }
}
