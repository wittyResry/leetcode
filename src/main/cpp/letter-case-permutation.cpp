class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        vector<string> res;
        char ch[15];
        int cnt = 0;
        for (int i = 0; i < S.size(); ++i) {
            char c = S[i];
            ch[i] = (c >= 'A' && c <= 'Z') ? c - 'A' + 'a': c;
        }
        ch[S.size()] = '\0';
        dfs(res, ch, 0, S.size());
        return res;
    }
    void dfs(vector<string> &res, char* ch, int i, int size) {
        if (i == size) {
            res.push_back(ch);
            return;
        }
        if (ch[i] >= 'A' && ch[i] <= 'Z') {
            ch[i] = (ch[i] >= 'A' && ch[i] <= 'Z') ? ch[i] - 'A' + 'a': ch[i];
        }
        if (ch[i] >= 'a' && ch[i] <= 'z') {
            dfs(res, ch, i+1, size);
            ch[i] = ch[i] - 'a' + 'A';
            dfs(res, ch, i+1, size);
        } else {
            dfs(res, ch, i+1, size);
        }
    }
};