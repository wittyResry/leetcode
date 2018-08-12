class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        vector<vector<int>> tmp;
        if (board.size() == 0) return;
        int r = board.size();
        int c = board[0].size();
        for (int i = 0; i < board.size(); ++i) {
            vector<int> t;
            for (int j = 0; j < board[i].size(); ++j) {
                int ct = 0;
                if (i+1 < r && board[i+1][j] == 1) ++ct;
                if (i-1 >= 0 && board[i-1][j] == 1) ++ct;
                if (j+1 < c && board[i][j+1] == 1) ++ct;
                if (j-1 >= 0 && board[i][j-1] == 1) ++ct;
                if (i+1 < r && j+1 < c && board[i+1][j+1] == 1) ++ct;
                if (i+1 < r && j-1 >= 0 && board[i+1][j-1] == 1) ++ct;
                if (i-1 >= 0 && j+1 < c && board[i-1][j+1] == 1) ++ct;
                if (i-1 >= 0 && j-1 >= 0 && board[i-1][j-1] == 1) ++ct;
                if (board[i][j] == 0) {
                    if (ct == 3) {
                        t.push_back(1);
                    } else {
                        t.push_back(0);
                    }
                } else {
                    if (ct == 2 || ct == 3) {
                        t.push_back(1);
                    } else {
                        t.push_back(0);
                    }
                }
            }
            tmp.push_back(t);
        }
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                board[i][j] = tmp[i][j];
            }
            tmp[i].clear();
        }
        tmp.clear();
    }
};