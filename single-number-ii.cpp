class Solution {
public:
    int singleNumber(vector<int>& nums) {
        map<int, int> mp;
        for (int i = 0; i < nums.size(); ++i) {
            mp[nums[i]] = mp[nums[i]] + 1;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (mp[nums[i]] != 3) return nums[i]; 
        }
        return -1;
    }
};