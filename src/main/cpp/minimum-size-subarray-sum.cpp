class Solution {
public:
    bool check(vector<int>& nums, int s, int len) {
        if (len <= 0) return false;
        int t = 0;
        for (int i = 0; i < len -1; ++i) {
            t += nums[i];
        }
        for (int i = len-1; i < nums.size(); ++i) {
            t += nums[i];
            t -= (i - len >= 0)?nums[i-len]:0;
            if (t >= s) return true;
        }
        return false;
    }
    int minSubArrayLen(int s, vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            sum += nums[i];
        }
        if (sum < s) return 0;
        //nlgn
        int left = 1, right = nums.size();
        int time = 0;
        for (;left < right && time < 20; ++time) {
            int mid = (left + right) / 2;
            bool isOk = check(nums, s, mid);
            if (isOk) right = mid;
            else left = mid;
        }
        return right;
    }
};