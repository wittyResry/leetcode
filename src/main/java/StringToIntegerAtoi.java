class StringToIntegerAtoi {
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = str.length();
        while (str.charAt(i) == ' ') ++i;
        for (; i < n; ++i) {
            if (str[i].charAt(i) == ' ') {
                break;
            }
            sb.append(str[i].charAt(i));
        }
        return parseInt(sb.toString());
    }
    private int parseInt(String s) {
        if ("".equals(s)) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            return -parseInt(s.substring(1));
        } else if (s.charAt(0) == '+') {
            return parseInt(s.substring(1));
        }
        long result = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return result;
    }
}
