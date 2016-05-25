class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> res;
        if (nums.size() <= 1) return nums;
        if (nums.size() == 2) {
            res.push_back(nums[0]);
            if (nums[1] != nums[0]) res.push_back(nums[1]);
            return res;
        }
        int c1 = nums[0], c2 = nums[0], cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (cnt1 == 0 || nums[i] == c1) {
                c1 = nums[i];
                ++cnt1;
            } else if (cnt2 == 0 || nums[i] == c2) {
                c2 = nums[i];
                ++cnt2;
            } else {
                --cnt1;
                --cnt2;
            }
        }
        cnt1 = cnt2 = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == c1) ++cnt1;
            if (nums[i] == c2) ++cnt2;
        }
        if (cnt1 > nums.size() / 3) {
            res.push_back(c1);
        }
        if (cnt2 > nums.size() / 3 && c2 != c1) {
            res.push_back(c2);
        }
        return res;
    }
};