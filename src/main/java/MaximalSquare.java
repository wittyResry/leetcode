public class MaximalSquare {
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] a = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                a[i][j] = 0;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int tmp = min((i-1 >= 0? a[i-1][j]:0), (j-1 >= 0? a[i][j-1]:0), ((i-1 >= 0 && j-1 >= 0)?a[i-1][j-1]:0));
                if ((matrix[i][j] - '0') == 0) a[i][j] = 0;
                else a[i][j] = (matrix[i][j] - '0') + tmp;
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (a[i][j] > res) res = a[i][j];
            }
        }
        return res * res;
    }
}
