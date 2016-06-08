class Solution {
public:
    string reverseString(string s) {
        char *temp = new char[s.length()+1];
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; --i) temp[cnt++] = s[i];
        temp[s.length()] = '\0';
        return string(temp);
    }
};