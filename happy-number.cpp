class Solution {
public:
    int get(int n) {
        int res = 0;
        while (n > 0) {
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }
    bool isHappy(int n) {
        for (int i = 0; i < 1005; ++i) {
            n = get(n);
        }
        if (n == 1) return true;
        return false;
    }
};