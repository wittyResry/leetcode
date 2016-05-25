public class Solution {
    public int rob(int[] nums) {
        /*动态规划：
        dp[i] = max(dp[i-2] + nums[i], dp[i-1]);
        */
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = Integer.max((i-2>=0?dp[i-2]:0) + nums[i], (i-1)>=0?dp[i-1]:0);
        }
        return dp[nums.length - 1];
    }
}