package Matrix;

public class matrixTozero73 {
    //矩阵中如果有一个0，那么它所在的行和列都要变0
    //首先先看一下第一行， 第一列有没有存在0，如果有，就先用一个boolean记录，最后用
    //然后遍历整个矩阵，如果遇到0，那么就把它所在的行顶点，列顶点设置为0
    //根据遍历后的行，列，顶点的0的情况，把0传染到整行，列
    //最后看一看之前的boolean，如果存在true就说明第一行，列是存在0的，那么就压整行变0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean i0 = false, j0 = false;

        // Check if the first row contains zero
        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                i0 = true;
                break;
            }
        }

        // Check if the first column contains zero
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                j0 = true;
                break;
            }
        }

        // Use the first row and column to mark zero positions
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set the zeros based on the marks
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the first row to zero if needed
        if (i0) {
            for (int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }

        // Set the first column to zero if needed
        if (j0) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
