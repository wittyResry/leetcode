const int M = 105;
class Solution {
public:
    int dp[M][M];
    int uniquePathsWithObstacles(vector<vector<int>>& mp) {
        int r = mp.size();
        if (r == 0) return 0;
        int c = mp[0].size();
        for (int i = 0; i < M; ++i) for (int j = 0; j < M; ++j) dp[i][j] = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                int ni = i + 1;
                int nj = j + 1;
                int val = mp[i][j];
                if (ni == 1 && nj == 1) {
                    if (val == 1) dp[ni][nj] = 0;
                    else dp[ni][nj] = 1;
                } else {
                    if (val == 1) dp[ni][nj] = 0;
                    else dp[ni][nj] = dp[ni - 1][nj] + dp[ni][nj - 1];
                }
                
            }
        }
        return dp[r][c];
    }
};