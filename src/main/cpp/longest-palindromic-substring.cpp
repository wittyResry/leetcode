#include<cstdio>
#include<string>
using namespace std;
/**
 * @author Qingyu Li
 * @since 2019/03/09
 */
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.size() == 0) {
            return "";
        }
        int start = 0, end = 1, len = s.size();
        for (int i = 0; i < len; i++) {
            int a = checkLen(s, i, i);//odd
            if (a > (end - start)) {
                start = i - a/2;
                end = i + a/2 + 1;
            }
            int b = checkLen(s, i, i+1);//even
            if (b > (end - start)) {
                start = i - b/2 + 1;
                end = i + 1 + b/2;
            }
        }
        return s.substr(start, end-start);
    }
    int checkLen(string s, int l, int r) {
        int len = s.size();
        while (l >= 0 && r < len && s[l] == s[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
};
int main() {
  Solution solution;
  printf("%s\n", solution.longestPalindrome("abba").c_str());
}