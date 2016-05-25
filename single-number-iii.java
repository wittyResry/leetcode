public class Solution {
    public int[] singleNumber(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s ^= nums[i];
        }
        Arrays.sort(nums);
        int res1 = 0;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i+1]) {
                res1 = nums[i];
                break;
            }
        }
        int[] vec = new int[2];
        vec[0] = res1;
        vec[1] = s ^ res1;
        return vec;
        
    }
}