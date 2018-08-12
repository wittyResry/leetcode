class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        int begin = 0 - k + nums.size();
        if (begin == nums.size()) begin = 0;
        vector<int> res;
        for (int i = 0; i < nums.size(); ++i) {
            res.push_back(nums[begin]);
            ++begin;
            if (begin == nums.size()) begin = 0;
        }
        for (int i = 0; i < nums.size(); ++i) {
            nums[i] = res[i];
        }
    }
};