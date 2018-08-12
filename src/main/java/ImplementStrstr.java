public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        for (int i = 0; i +  needle.length() - 1 < haystack.length(); ++i) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
