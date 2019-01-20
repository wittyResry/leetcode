class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        } else if (nums.size() == 1) {
            return nums[0];
        }
        vector<int> dp;
        dp.push_back(nums[0]);
        int res = dp[0];
        for (int i = 1; i < nums.size(); i++) {
            if (dp[i-1] + nums[i] >= nums[i]) {
                dp.push_back(dp[i-1] + nums[i]);
            } else {
                dp.push_back(nums[i]);
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};