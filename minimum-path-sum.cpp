class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        vector<vector<int> > dp;
        //if (grid.size() == 0 || grid[0].size() == 0) return 0;
        int r = grid.size();
        int c = grid[0].size();
        for (int i = 0; i < r; ++i) for (int j = 0; j < c; ++j) if (i > 0 || j > 0) {
            if (i > 0 && j == 0) grid[i][j] = grid[i-1][j] + grid[i][j];
            else if (i == 0 && j > 0) grid[i][j] = grid[i][j-1] + grid[i][j];
            else if (i > 0 && j > 0) grid[i][j] = (grid[i-1][j] < grid[i][j-1])? grid[i][j] + grid[i-1][j] : grid[i][j] + grid[i][j-1];
        }
        return grid[r-1][c-1];
    }
};