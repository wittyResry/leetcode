public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        --n;
        StringBuilder sb =  new StringBuilder();
        for (; n >= 0;) {
            char s = (char)((n % 26) + 'A');
            sb.append(s);
            n /= 26;
            if (n == 0) break;
            n -= 1;
        }
        sb.reverse();
        return sb.toString();
    }
}
