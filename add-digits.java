public class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            String s = String.valueOf(num);
            int sum = 0;
            for (int i = 0; i < s.length(); ++i) {
                sum += s.charAt(i) - '0';
            }
            num = sum;
        }
        return num;
    }
}