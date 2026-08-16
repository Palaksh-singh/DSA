class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] result = new int[n];

        for (int col = 0; col < n; col++) {
            int curCol = col;
            for (int row = 0; row < m; row++) {
                int dir = grid[row][curCol];
                int nextCol = curCol + dir;

                if (nextCol < 0 || nextCol >= n || grid[row][nextCol] != dir) {
                    curCol = -1;
                    break;
                }

                curCol = nextCol;
            }
            result[col] = curCol;
        }

        return result;
    }
}