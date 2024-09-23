package graph;

public class surroned130 {
    //矩阵中，有X和O，凡是完全被X围绕的O都要变成O，如果O旁边不是X而是NONE（边界），那就不用变）
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Capture all 'O's that are connected to the boundary
        for (int i = 0; i < rows; i++) {
            // Start from the first and last column
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            // Start from the first and last row
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        // Step 2: Flip all the remaining 'O's to 'X', and all the temporary '*' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // flip surrounded 'O' to 'X'
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';  // flip temporary '*' back to 'O'
                }
            }
        }
    }

    // Use Depth-First Search to mark the 'O's that are connected to the boundary
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '*';  // Temporarily mark 'O' as '*'

        // Explore in all 4 directions
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
