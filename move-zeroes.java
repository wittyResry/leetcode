public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = nums.length-1; i>=0; --i) {
            int idx = -1;
            for (int j = i; j >= 0; --j) {
                if (nums[j] == 0) {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) break;
            for (int j = idx; j < i; j++) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }
}