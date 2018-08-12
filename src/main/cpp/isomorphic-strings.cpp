class Solution {
public:
    bool isOk(string s, string t) {
        int a[255];
        for (int i = 0; i < 255; ++i) {
            a[i] = -1;
        }
        if (s.size() == 0) return t.size() == 0;
        if (t.size() == 0) return s.size() == 0;
        if (s.size() != t.size()) return true;
        for (int i = 0; i < s.size(); ++i) {
            int t1 = s.at(i) - '\0';
            int t2 = t.at(i) - '\0';
            if (a[t1] == -1) a[t1] = t2;
            else if (a[t1] == t2) continue;
            else return false;
        }
        return true;
    }
    bool isIsomorphic(string s, string t) {
        return isOk(s, t) && isOk(t, s);
    }
};