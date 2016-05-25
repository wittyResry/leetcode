class Solution {
public:
    int hammingWeight(uint32_t n) {
        long long t = n;
        int res = 0;
        while (t > 0) {
            t -= t & (-t);
            ++res;
        }
        return res;
    }
};