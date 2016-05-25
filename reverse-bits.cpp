class Solution {
public:
    int a[64];
    uint32_t b[64];
    int cnt = 0;
    uint32_t reverseBits(uint32_t n) {
        for (; n > 0 ;){
            a[cnt++] = n % 2;//n = a[i] * 2^i;
            n /= 2;
        }
        b[0] = 1;
        for (int i = 1; i < 32; ++i) {
            b[i] = b[i-1] * 2;
        }
        n = 0;
        for (int i = 0; i < 32; ++i) {
            n += a[i] * b[31 - i];
        }
        return n;
    }
};