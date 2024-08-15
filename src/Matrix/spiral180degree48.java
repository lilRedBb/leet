package Matrix;

public class spiral180degree48 {
    public void rotate180(int[][] matrix) {
        int n = matrix.length;

        // Swap elements diagonally for 180-degree rotation
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = temp;
            }
        }

        // If the matrix has an odd number of rows, reverse the middle row
        if (n % 2 == 1) {
            int mid = n / 2;
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[mid][j];
                matrix[mid][j] = matrix[mid][n - j - 1];
                matrix[mid][n - j - 1] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        //90du
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reflect the matrix horizontally
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    // Main method for testing

}
