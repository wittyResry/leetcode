class Solution {
public:
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    void dfs(int x, int y, int r, int c, vector<vector<char>>& grid) {
        grid[x][y] = '0';
        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == '1') {
                dfs(nx, ny, r, c, grid);
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int r = grid.size();
        if (r == 0) return 0;
        int c = grid[0].size();
        int res = 0;
        for (int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    dfs(i, j, r, c, grid);
                }
            }
        }
        return res;
    }
};