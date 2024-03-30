package blind75.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    int[] deltaRow = new int[] {0,-1,0,1};
    int[] deltaCol = new int[] {-1,0,1,0};
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islandNumber = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandNumber++;
                    visitDfs(grid, i, j);
                }
            }
        }

        return islandNumber;
    }

    private void visitDfs(char[][] grid, Integer r, Integer c) {
        grid[r][c] = '0';

        for (int i = 0; i < 4; i++) {
            int newRow = r + deltaRow[i];
            int newCol = c + deltaCol[i];
            if(0 <= newRow && newRow < m && 0 <= newCol && newCol < n && grid[newRow][newCol] == '1') {
                visitDfs(grid, newRow, newCol);
            }
        }
    }

}
