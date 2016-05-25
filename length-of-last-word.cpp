class Solution {
public:
    int lengthOfLastWord(string s) {
        if (s.size() == 0) return 0;
        int begin = -1;
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s.at(i) != ' ') {
                begin = i;
                break;
            }
        }
        if (begin == -1) return 0;
        int i = begin;
        for (; i >= 0; --i)  {
            if (s[i] == ' ') {
                break;
            }
        }
        return begin - i;
    }
};