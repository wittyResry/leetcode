class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) return "";
        int max_len = strs[0].size();
        for (int i = 1; i < strs.size(); ++i) {
            int len_i = strs[i].size();
            if (len_i < max_len) max_len = len_i;
        }
        string res = "";
        for (int i = 0; i < max_len; ++i) {
            char ch = strs[0].at(i);
            bool flag = 0;
            for (int j = 1; j < strs.size(); ++j) {
                if (strs[j].at(i) != ch) {
                    flag = 1;
                    break;
                }
            }
            if (!flag) {
                res += ch;
            } else {
                break;
            }
        }
        return res;
    }
};