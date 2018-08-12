class Solution {
public:
    string removeDuplicateLetters(string s) {
        string res;
        int count[256] = {0};
        bool vis[256] = {false};
        // step1: init
        for (int i = 0; i < 256; ++i) {
            count[i] = 0;
            vis[i] = false;
        }
        // step2: count
        for (char ch:s) {
            ++count[ch];
        }
        // step3: process
        for (char ch:s) {
            --count[ch];
            if (vis[ch]) {
                continue;
            }
            char cur;
            while (res.size() > 0 && ch < (cur = res.back()) && count[cur] > 0) {
                vis[cur] = false;
                res.pop_back();
            }
            res.push_back(ch);
            vis[ch] = true;
        }
        return res;
    }
};