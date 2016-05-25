const int M = 2000005;
int a[M];
int b[M];
int cnt = 0;
class Solution {
public:
    int getPrime(int n) {
        a[0] = a[1] = 1;
        for (int i = 2; i < n+1; ++i) {
            if (!a[i]) {
                b[cnt++] = i;
            }
            for (int j = 0; j < cnt; ++j) {
                int tmp = i * b[j];
                if (tmp > n) break;
                a[tmp] = 1;
            }
        }
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            if (!a[i]) ++res;
        }
        return res;
    }
    bool isPrime(int t) {
        if (t == 0 || t == 1) return false;
        for (int i = 2;; i++) {
            if (i * i > t) break;
            if (t % i == 0) return false;
        }
        return true;
    }
    int countPrimes(int n) {
        return getPrime(n-1);
    }
};