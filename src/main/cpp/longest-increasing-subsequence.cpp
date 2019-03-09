class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        vector<int> res;
        res.push_back(nums[0]);
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > res[res.size() - 1]) {
                res.push_back(nums[i]);
            } else {
                int l = 0, r = res.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (nums[i] > res[mid]) l = mid + 1;
                    else r = mid;
                }
                res[l] = nums[i];
            }
        }
        return res.size();
    }
};