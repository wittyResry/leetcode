class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if (nums.size() == 0) {
            return 0;
        }
        int i = 0, j = nums.size() -1;
        if (target > nums[j]) {
            i = j + 1;
        }
        for (; i < j;) {
            int mid = i + (j - i) / 2;
            if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
};