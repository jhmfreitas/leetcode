package blind75.medium;

import java.util.ArrayList;
import java.util.List;

/*

Time Complexity: O(N)

I used -101 here to signal that i have visited that node already

 */
public class SpiralMatrix {

    public enum Direction {
        RIGHT(0,1),
        LEFT(0,-1),
        UP(-1,0),
        DOWN(1,0);

        public int row;
        public int  col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        Direction currentDirection = Direction.RIGHT;

        int totalNumbers = matrix.length * matrix[0].length;

        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < totalNumbers; i++) {
            int currentValue = matrix[currentRow][currentCol];
            if (currentValue != -101) {
                res.add(currentValue);
                matrix[currentRow][currentCol] = -101;
            }

            if (res.size() == totalNumbers)
                break;

            // Check if next position is invalid
            if (isInvalidPosition(matrix, currentRow, currentDirection, currentCol)) {
                currentDirection = getNextDirection(currentDirection);
            }

            currentRow = currentRow + currentDirection.row;
            currentCol = currentCol + currentDirection.col;
        }

        return res;
    }

    private static boolean isInvalidPosition(int[][] matrix, int currentRow, Direction currentDirection, int currentCol) {
        int nextRow = currentRow + currentDirection.row;
        int nextCol = currentCol + currentDirection.col;
        return nextRow < 0 || nextCol < 0 || nextRow == matrix.length || nextCol == matrix[0].length || matrix[nextRow][nextCol] == -101;
    }

    private static Direction getNextDirection(Direction currentDirection) {
        if (currentDirection == Direction.RIGHT) {
            return Direction.DOWN;
        } else if (currentDirection == Direction.DOWN) {
            return Direction.LEFT;
        } else if (currentDirection == Direction.LEFT) {
            return Direction.UP;
        } else {
            return Direction.RIGHT;
        }
    }
}
