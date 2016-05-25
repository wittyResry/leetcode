class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int> > res;
        if (numRows == 0) {
            return res;
        }
        int n = numRows;
        res.push_back(vector<int>(1,1));
        for (int i = 1; i < n; ++i) {
            vector<int>t(i+1, 0);
            t[0] = t[i] = 1;
            for (int j = 1; j <= i-1; ++j) {
                t[j] = res[i-1][j-1] + res[i-1][j];
            }
            res.push_back(t);
        }
        return res;
    }
};