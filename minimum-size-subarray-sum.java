public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0, end = 0;
        int res = Integer.MAX_VALUE;
        while (start < nums.length && end < nums.length) {
            while (sum < s && end < nums.length) {
                sum += nums[end++];
                if (sum >= s && end - start < res) res = end - start;
            }
            while (sum >= s && start < nums.length) {
                sum -= nums[start++];
                if (sum >= s && end - start < res) res = end - start;
            }
        }
        if (res == Integer.MAX_VALUE) res = 0;
        return res;
    }
}