class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) return 0;
        int m = prices[0];
        int res = 0;
        for (int i = 1; i < prices.size(); ++i) {
            if (prices[i] - m > res) res = prices[i] - m;
            if (prices[i] < m) m = prices[i];
        }
        return res;
    }
};