public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int i = 0;
        for (; i < strs[0].length(); ++i) {
            char ch = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; ++j) {
                if (strs[j] == null || i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    break;
                }
            }
            if (j != strs.length) break;
        }
        return strs[0].substring(0, i);
    }
}