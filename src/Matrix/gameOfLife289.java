package Matrix;

public class gameOfLife289 {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Iterate through each cell on the board
        //遍历每一个格子周围的8个格子（如果有的话，所以才会用max,min函数来判断）
        //8个格子里，每个格子如果是0的话就 在liveneighour上+1， 这里用到的是位运算， 这样这个cell目前的state就不会被待会后面的 |=操作改变
        //更新玩Liveneighour以后，就对这个格子的next state修改，同样是位运算，不会真实的改变
        //更新完所有以后，再总体的真正改变矩阵
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int liveNeighbors = 0;

                // Count the live neighbors
                //每个格子周围的8个小格子，有可能没有8个
                for (int x = Math.max(0, i - 1); x < Math.min(m, i + 2); ++x) {
                    for (int y = Math.max(0, j - 1); y < Math.min(n, j + 2); ++y) {
                        liveNeighbors += board[x][y] & 1;
                    }
                }

                //计算完一个格子身边的8个格子了，就来更新一下这个格子的next state
                // Apply the Game of Life rules
                if (board[i][j] == 1 && (liveNeighbors == 3 || liveNeighbors == 4)) {
                    board[i][j] |= 0b10; // Mark as live in the next state
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] |= 0b10; // Mark as live in the next state
                }
            }
        }

        // Update the board to the next state
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] >>= 1; // Shift right to get the next state
            }
        }
    }
}

/**Current State Check:

 The expression board[x][y] & 1 is used to extract the least significant bit (LSB) of the cell's value,
 which represents the current state of the cell (alive or dead).
 board[x][y] & 1 will be 1 if the cell is currently alive and 0 if the cell is currently dead.
 Storing Next State:

 During the iteration, we use the higher bit to store the next state. This is done using bitwise OR
 operation (| 0b10), which sets the second bit while keeping the current state intact in the LSB.
 The values after the OR operation can be:
 0b00 (0) for a currently dead cell that stays dead.
 0b01 (1) for a currently alive cell that stays alive.
 0b10 (2) for a currently dead cell that becomes alive.
 0b11 (3) for a currently alive cell that dies.**/
