class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();
        if (n == 0) {
            return digits;
        }
        digits[n-1] = digits[n-1] + 1;
        if (digits[n-1] <= 9) return digits;
        bool is_all_night = true;
        for (int i = 0; i < n-1; i++) if(digits[i] != 9) is_all_night = false;
        if (is_all_night) {
            vector<int> ret;
            ret.push_back(1);
            for (int i = 0; i < n; ++i) {
                ret.push_back(0);
            }
            return ret;
        }
        int j = n - 1;
        while (j >= 1 && digits[j] == 10) {
            digits[j-1] = digits[j-1] + 1;
            digits[j] = 0;
            --j;
        }
        return digits;
    }
};