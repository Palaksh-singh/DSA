class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row, '.');
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solve(0, board, n, leftRow, upperDiagonal, lowerDiagonal, res);
        return res;
    }

    private void solve(int col, char[][] board, int n, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> res) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i<n; i++) {
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n-1 + col-row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n-1 + col - row] = 1;

                solve(col+1, board, n, leftRow, upperDiagonal, lowerDiagonal, res);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n-1 + col - row] = 0;
            }
        }
    }
}