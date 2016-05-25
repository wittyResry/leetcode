class Solution {
public:
    bool wordBreakHelp(string s, unordered_set<string>& wordDict, set<string> &unMatch) {
        if (s.length() == 0) return true;
        for (int i = 1; i <= s.length(); ++i) {
            string prefixString = s.substr(0, i);
            if (wordDict.find(prefixString) != wordDict.end()) {
                string suffixString = s.substr(i);
                if (unMatch.find(suffixString) != unMatch.end()) continue;
                else {
                    bool flag = wordBreakHelp(suffixString, wordDict, unMatch);
                    if (flag) {
                        return true;
                    } else {
                        unMatch.insert(suffixString);
                    }
                }
            }
        }
        return false;
    }
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        set<string>un_match;
        return wordBreakHelp(s, wordDict, un_match);
    }
};