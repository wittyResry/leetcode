class Solution {
public:
    int addDigits(int num) {
        while (num >= 10) {
            char s[15];
            sprintf(s, "%d", num);
            int sum = 0;
            for (int i = 0;s[i] != '\0'; ++i) {
                int tmp = s[i] - '0';
                sum += tmp;
            }
            num = sum;
        }
        return num;
    }
};