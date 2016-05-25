public class Solution {
    public int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }
        String s = String.valueOf(x);
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        long res = 0;
        for (int i = 0; i < s.length(); ++i) {
            res = (s.charAt(i) - '0') + res * 10;
        }
        if (flag < 0) res = -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}