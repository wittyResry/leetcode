class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        if (k == 0 || nums.size() <= 1) return false;
        map<int,int>s;
        int tail = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i - tail > k) {
                s[nums[tail]] = 0;
                tail++;
            }
            if (s[nums[i]] == 1) {
                return true;
            } else {
                s[nums[i]] = 1;
            }
        }
        return false;
    }
};