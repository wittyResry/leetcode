class Solution {
public:
    string convertToBase7(int num) {
        char ch[105];
        int cnt = 0;
        if (num < 0) {
            ch[cnt++] = '-';
            num = -num;
        }
        while (num > 0) {
            ch[cnt++] = (num % 7) + '0';
            num /=7;
        }
        if (cnt == 0) {
            return "0";
        }
        int begin = ch[0] == '-' ? 1 : 0;
        for (int i = begin, j = cnt-1; i < j; ++i,--j) {
            char t = ch[i];
            ch[i] = ch[j];
            ch[j] = t;
        }
        ch[cnt++] = '\0';
        return ch;
    }
};