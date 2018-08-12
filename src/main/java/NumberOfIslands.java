public class NumberOfIslands {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1}; 
    public void dfs(int i, int j, int n, int m, char[][] grid) {
        grid[i][j] = '0';
        for (int dir = 0; dir < 4; ++dir) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (grid[nx][ny] == '1') {
                    dfs(nx, ny, n, m, grid);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j, n, m, grid);
                    res++;
                }
            }
        }
        return res;
    }
}
