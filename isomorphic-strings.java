public class Solution {
    public boolean isOk(String s, String t) {
        int[]a = new int[255];
        for (int i = 0; i < 255; ++i) {
            a[i] = -1;
        }
        if (s == null) return t == null;
        if (t == null) return s == null;
        if (s.length() != t.length()) return true;
        for (int i = 0; i < s.length(); ++i) {
            int t1 = s.charAt(i) - '\0';
            int t2 = t.charAt(i) - '\0';
            if (a[t1] == -1) a[t1] = t2;
            else if (a[t1] == t2) continue;
            else return false;
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        return isOk(s, t) && isOk(t, s);
    }
}