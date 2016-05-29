class Solution {
public:
/**
 * 动态规划：dp[i] = i&1 + dp[i>>1]
 */
    vector<int> countBits(int num) {
        vector<int> res;
        res.push_back(0);
        for (int i = 1; i <= num; ++i) {
            res.push_back((i&1) + res[i>>1]);
        }
        return res;
    }
};
/**
树状数组:
int lowbit(int x){  
    return x&(x^(x–1));  
}
int lowbit(int x){  
    return x&(-x);  
}  
 * /