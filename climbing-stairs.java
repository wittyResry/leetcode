public class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1];
            if (i-2>=0) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}