package Matrix;

public class sodukuValid36 {
    //一共81个方格组成的大矩阵
    //如果是valid的数独，那么每row必须不能有重复的1-9
    //每col必须不能有重复
    //每个3*3的小单位方块，不能偶重复
    //(r / 3) * 3 + (c / 3); 这个刚好能通过每个小格子的横纵坐标，计算出它在的小单位方块是第几个（0-8）
    public boolean isValidSudoku(char[][] board) {
        // Arrays to keep track of the presence of numbers in rows, columns, and sub-boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // If the current cell is not empty
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1'; // Convert '1'-'9' to 0-8
                    int boxIndex = (r / 3) * 3 + (c / 3); // Calculate the index for the sub-box

                    // Check if the number is already present in the current row, column or sub-box
                    if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    // Mark the number as seen in the current row, column, and sub-box
                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        // If no conflicts were found, the board is valid
        return true;
    }
}
