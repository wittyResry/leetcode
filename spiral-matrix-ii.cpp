int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
class Solution {
public:
    bool isIn(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int> > res;
        if (n == 0) return res;
        for (int i = 0; i < n; ++i) {
            vector<int> tr;
            for (int j = 0; j < n; ++j) {
                tr.push_back(-100);
            }
            res.push_back(tr);
        }
        int cx = 0, cy = 0, cnt = 0;
        int dir = 0;
        res[0][0] = cnt + 1; ++cnt;
        for (dir = 3; cnt < n * n;) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            while(isIn(nx, ny, n) && res[nx][ny] == -100) {
                res[nx][ny] = cnt + 1; ++cnt;
                cx = nx; cy = ny;
                nx = cx + dx[dir]; ny = cy + dy[dir];
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }
};