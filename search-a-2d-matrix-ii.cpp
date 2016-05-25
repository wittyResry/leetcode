class Solution {
public:
    bool isOk(vector<int> & a, int target) {
        if (a.size() == 0) return false;
        int l = 0, r = a.size() - 1;
        for (int time = 0; time < 64 && l + 1 < r; ++time) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) return true;
            if (a[mid] > target) r = mid;
            else l = mid;
        }
        if (a[l] == target) return true;
        if (a[r] == target) return true;
        return false;
    } 
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0) return false;
        for (int i = 0; i < matrix.size(); ++i) {
            bool is = isOk(matrix[i], target);
            if (is) return true;
        }
        return false;
    }
};