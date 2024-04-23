package blind75.medium;

public class WordSearch {
    int[] deltaCol = new int[]{-1, 0, 1, 0};
    int[] deltaRow = new int[]{0,-1,0,1};
    private int n;
    private int m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(index) || board[i][j] == '#')
            return false;

        char tmp = board[i][j];
        board[i][j] = '#'; // Mark as visited

        for (int k = 0; k < 4; k++) {
            int newRow = i + deltaRow[k];
            int newCol = j + deltaCol[k];
            if(dfs(board, newRow, newCol, word, index + 1))
                return true;
        }

        board[i][j] = tmp;
        return false;
    }
}
