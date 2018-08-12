class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int cnt = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0 || nums[i] != nums[i-1]) {
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
};