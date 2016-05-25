class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if (n == 0) {
            return;
        }
        vector<vector<int>> ret;
        for (int i = 0; i < n; ++i) {
            vector<int> tr;
            for (int j = 0; j < n; ++j) {
                tr.push_back(matrix[i][j]);
            }
            ret.push_back(tr);
        }
        int L = n / 2;
        for (int l = 0; l < L; ++l) {
            for (int ct = 0; ct < n-2*l; ct++) {
                ret[l+ct][n-1-l] = matrix[l][l+ct];
                ret[n-1-l][n-1-l-ct] = matrix[l+ct][n-1-l];
                ret[n-1-l-ct][l] = matrix[n-1-l][n-1-l-ct];
                ret[l][l+ct] = matrix[n-1-l-ct][l];
            }
        }
        for (int i = 0; i < n; ++i)for(int j = 0; j < n; ++j) matrix[i][j] = ret[i][j];
    }
};