public class Solution {
    public static boolean wordPattern(String pattern, String str) {
        Map<String, String> a2b = new HashMap<String, String>();
        Map<String, String> b2a = new HashMap<String, String>();
        String[] tokens = str.split(" ");
        if (tokens.length != pattern.length()) return false;
        int i = 0;
        for (String token : tokens) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(pattern.charAt(i));
            if (a2b.containsKey(tmp.toString())) {
                String r = a2b.get(tmp.toString());
                if (!r.equals(token)) return false;
            } else if (b2a.containsKey(token)) {
                String r = b2a.get(token);
                if (!r.equals(tmp.toString())) return false;
            } else {
                a2b.put(tmp.toString(), token);
                b2a.put(token, tmp.toString());
            }

            ++i;
        }
        return true;
    }
}