const int M = 105;
class Solution {
public:
    int f[M][M];
    int fac(int n) {
        if (n == 0) return 1;
        int tmp = 1;
        for (int i = 1; i <= n; ++i) tmp = tmp * i;
        return tmp;
    }
    int C(int n, int m) {
        return fac(n) / (fac(m) * fac(n - m));
    }
    void test() {
        for (int i = 0; i < M; ++i) f[i][0] = f[0][i] = 0;
        f[1][1] = 1;
        for (int i = 1; i < M; ++i) {
            for (int j = 1; j < M; ++j) {
                if (i == 1 && j == 1) continue;
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
    }
    int uniquePaths(int m, int n) {
        if (n == 0 || m == 0) return 0;
        if (n == 1 || m == 1) return 1;
        int mm = m - 1;
        int nn = (n - 1) + (m - 1);
        test();
        return f[m][n];
    }
};