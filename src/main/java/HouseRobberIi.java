public class HouseRobberIi {
    public int rob(int[] nums) {
        /*动态规划：
        dp[i] = max(dp[i-2] + nums[i], dp[i-1]);
        */
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i == nums.length - 1) {
                dp[i] = Integer.max((i-1)>=0?dp[i-1]:0, (i-2)>=0?dp[i-2]:0);
                continue;
            }
            dp[i] = Integer.max((i-2>=0?dp[i-2]:0) + nums[i], (i-1)>=0?dp[i-1]:0);
        }
        int[] dp2 = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            dp2[i] = Integer.max((i-2>=1?dp2[i-2]:0) + nums[i], (i-1)>=1?dp2[i-1]:0);
        }
        int res = dp[nums.length - 1];
        if (dp2[nums.length - 1] > res) res = dp2[nums.length - 1];
        return dp[nums.length - 1];
    }
}
