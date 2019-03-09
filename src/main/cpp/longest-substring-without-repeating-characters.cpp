class Solution {
public:
//解法一：
    int lengthOfLongestSubstring(string s) {
        char mp[128] = {0};
        for (int i = 0; i < 128; ++i) {
            mp[i] = 0;
        }
        int n = s.size(), res = 0;
        for (int i = 0, j = 0; i < n || j < n;) {
            if (j < n && !mp[s[j]]) {
                mp[s[j++]] = 1;
            } else {
                //无脑滑动窗口出栈，直到mp[s[j]] == 0，这里有一个优化，跳跃到最右边s[j]的index+1，这样就不用一个一个增加
                mp[s[i++]] = 0;
            }
            res = max(res, j - i);
        }
        return res;
    }
//解法二：
    int lengthOfLongestSubstring(string s) {
        int mp[128];//记录当前扫描到的字符中下标位置Max，-1代表此字符没有出现过
        for (int i = 0; i < 128; i++) mp[i] = -1;
        int n = s.size(), res = 0, i = -1;
        for (int j = 0; j < n; ++j) {
            if (mp[s[j]] != -1)  {
                i = max(i, mp[s[j]]);
            }
            mp[s[j]] = max(mp[s[j]], j);
            res = max(res, j - i);
        }
        return res;
    }
};