class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> res(nums.size());
        if (nums.size() == 0) return res;
        long t = nums[0];
        res[nums.size() - 1] = 1;
        for (int i = nums.size() - 1; i > 0; --i) {
            res[i-1] = res[i] * nums[i];
        }
        int left = 1;
        for (int i = 0; i < nums.size(); ++i) {
            res[i] = res[i] * left;
            left *= nums[i];
        }
        return res;
    }
};