class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        for (int i = 0; i < 60; ++i) {
            int mid = (left + right) / 2;
            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                if (nums[mid] == target) return mid;
                if (nums[left] == target) return left;
                if (nums[right] == target) return right;
            }
            if (nums[mid] > nums[left]) {
                if (target > nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (target > nums[left] || target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        return -1;
    }
};