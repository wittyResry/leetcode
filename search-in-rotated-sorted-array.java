```
public class Solution {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        for (int i = 0; i < 65; ++i) {
            int mid = (left + right) / 2;
            if (nums[left] == target || nums[right] == target || nums[mid] == target) {
                return nums[left] == target ? left : (nums[right] == target ? right : mid);
            }
            if (nums[left] < nums[mid]) {
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
}
```