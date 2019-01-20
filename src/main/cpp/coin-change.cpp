class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp;
        dp.push_back(0);
        for (int i = 1; i <= amount; i++) {
            dp.push_back(0x7f7f7f7f);
            for (int j = 0; j < coins.size(); j++) {
                int c = coins[j];
                if (i - c >= 0 && dp[i-c] + 1 < dp[i]) {
                    dp[i] = dp[i-c] + 1;
                }
            }
        }
        return dp[amount] < 0x70707070 ? dp[amount] : -1;
    }
};