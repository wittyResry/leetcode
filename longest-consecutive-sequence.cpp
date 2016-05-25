class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        int ret = 0, cnt = 0;
        sort(nums.begin(), nums.end());
        int tn = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                nums[tn++] = nums[i];
            } else {
                if (nums[i] != nums[i-1]) {
                    nums[tn++] = nums[i];
                }
            }
        }
        n = tn;
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                cnt = 1;
            } else if (nums[i-1] + 1 == nums[i]) {
                cnt = cnt + 1;
            } else {
                cnt = 1;
            }
            if (cnt > ret) ret = cnt;
        }
        return ret;
    }
};