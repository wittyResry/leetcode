public class NumMatrix {
    public int[][] a;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        a = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                a[i][j] = matrix[i][j] + ((i - 1 >= 0) ? a[i - 1][j] : 0)
                          + ((j - 1 >= 0) ? a[i][j - 1] : 0)
                          - ((i - 1 >= 0 && j - 1 >= 0) ? a[i - 1][j - 1] : 0);
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        if (a == null)
            return 0;
        return a[r2][c2] - ((r1 - 1 >= 0 && c2 >= 0) ? a[r1 - 1][c2] : 0)
               - ((r2 >= 0 && c1 - 1 >= 0) ? a[r2][c1 - 1] : 0)
               + ((r1 - 1 >= 0 && c1 - 1 >= 0) ? a[r1 - 1][c1 - 1] : 0);
    }
}
