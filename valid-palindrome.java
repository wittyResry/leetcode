public class Solution {
    private boolean isOk(char ch) {
        return ((ch >= 'a') && (ch <= 'z')) || ((ch >= 'A') && (ch <= 'Z')) || ((ch >= '0') && (ch <= '9'));
    }
    private boolean isEqual(char ch1, char ch2) {
        Integer a1 = ((ch1 >= 'a')? new Integer(ch1 - 'a') : ((ch1 >= 'A')?new Integer(ch1 - 'A'):new Integer(26 + ch1 - '0')));
        Integer a2 = ((ch2 >= 'a')? new Integer(ch2 - 'a') : ((ch2 >= 'A')?new Integer(ch2 - 'A'):new Integer(26 + ch2 - '0')));
        return a1.equals(a2);
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        for (; i < j;) {
            if (i == j) break;
            for(;i<j && !isOk(s.charAt(i));++i);
            if (i == j) break;
            for (;i<j && !isOk(s.charAt(j)); --j);
            if (i == j) break;
            if (isEqual(s.charAt(i) , s.charAt(j))) {
                ++i; --j;
            } else {
                return false;
            }
        }
        return true;
    }
}