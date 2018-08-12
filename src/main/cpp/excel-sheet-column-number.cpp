#include <cstdio>
#include <cstring>
class Solution {
public:
    char s[105];
    int titleToNumber(string ss) {
        strcpy(s, ss.c_str());
        int n = strlen(s);
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            int tmp = s[i] - 'A' + 1;
            sum = sum * 26 + tmp;
        }
        return sum;
    }
};