class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        } else if (nums.size() <= 2) {
            return nums.size() == 1 ? nums[0] : max(nums[0], nums[1]);
        }
        vector<int> dp;
        dp.push_back(nums[0]);
        dp.push_back(max(nums[0], nums[1]));
        for (int i = 2; i < nums.size(); i++) {
            dp.push_back(max(dp[i-1], dp[i-2] + nums[i]));
        }
        return dp[nums.size() - 1];
    }
};