package Matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix54 {
    /**[1  2  3  4]
     * [5  6  7  8]
     * [9,10,11,12]
     * 会得到
     * 1234 - 8 12 - 11 10 9 - 5 6 7 8
     * **/







    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();

        final int m = matrix.length;
        final int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int r1 = 0, c1 = 0;
        int r2 = m - 1, c2 = n - 1;

        //这里的++j和j++是一个效果的，都是在add以后才会触发++
        //这里就是先把第一行加进去，再从第二行开始，加最后一列；再从最后一行开始，反向加入；再从第一列开始，从倒数第二行加入
        //一圈结束后，如果元素个数达不到mn，那么四个维度都集体向内收紧1，然后继续这个逻辑
        while (ans.size() < m * n) {
            for (int j = c1; j <= c2 && ans.size() < m * n; ++j) {
                ans.add(matrix[r1][j]);
            }
            for (int i = r1 + 1; i <= r2 && ans.size() < m * n; ++i) {
                ans.add(matrix[i][c2]);
            }
            for (int j = c2 - 1; j >= c1 && ans.size() < m * n; --j) { // Adjusted range
                ans.add(matrix[r2][j]);
            }
            for (int i = r2 - 1; i > r1 && ans.size() < m * n; --i) { // Adjusted range
                ans.add(matrix[i][c1]);
            }
            ++r1;
            ++c1;
            --r2;
            --c2;
        }

        return ans;
    }
}
