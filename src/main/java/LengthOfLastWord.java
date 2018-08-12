public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        boolean flag = false;
        int begin = s.length() -1 ;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                flag = true;
                begin = i;
                break;
            }
        }
        if (flag == false) {
            return 0;
        }
        int i = begin;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return begin - i;
    }
}
