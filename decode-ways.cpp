#include<cstring>
#include<cstdlib>
const int M = 100005;
char s[M];
int dp[M];
class Solution {
public:
    bool check1(char ch) {
        return ch >= '1' && ch <= '9';
    }
    bool check2(char ch1, char ch2) {
        if (ch1 <= '0' || ch1 >= '3') {
            return false;
        } else {
            if (ch1 == '1') {
                return ch2 >= '0' && ch2 <= '9';
            } else {
                return ch2 >= '0' && ch2 <= '6';
            }
        }
    }
    int process(char* s) {
        int len = strlen(s);
        if (dp[len] != -1) return dp[len];
        int& res = dp[len];
        if (len == 0) {
            res = 1;
        } else if (len == 1) {
            res = 0;
            char ch = s[0];
            if (check1(ch)) res = process(&s[1]);
            else res = 0;
        } else {
            char ch1 = s[0], ch2 = s[1];
            res = 0;
            if (check1(ch1)) res += process(&s[1]);
            if (check2(ch1, ch2)) res += process(&s[2]);
        }
        return res;
    }
    int numDecodings(string str) {
        for (int i = 0; i < M; ++i) dp[i] = -1;
        strcpy(s, str.c_str());
        if (strcmp("", s) == 0) return 0;
        return process(s);
    }
};