/**
 * @author Qingyu Li
 */
public class ReverseVowels {
    private static final String VOWELS = "aeiouAEIOU";

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j;) {
            while (!isVowel(charArray[i]) && i < j)
                ++i;
            while (!isVowel(charArray[j]) && i < j)
                --j;
            if (i < j) {
                char tmp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = tmp;
                ++i;
                --j;
            }
        }
        return new String(charArray);
    }

    private boolean isVowel(char ch) {
        if (VOWELS.indexOf(ch) != -1) {
            return true;
        }
        return false;
    }
}
