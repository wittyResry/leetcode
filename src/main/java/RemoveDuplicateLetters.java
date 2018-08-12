
public class RemoveDuplicateLetters {
    public RemoveDuplicateLetters() {
    }

    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        int[] count = new int[256];
        boolean[] vis = new boolean[256];
        //step1:init
        for (int i = 0; i < 256; ++i) {
            count[i] = 0;
            vis[i] = false;
        }
        //step2:count
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }
        //step3:process
        for (char ch : s.toCharArray()) {
            --count[ch];
            if (vis[ch]) {
                continue;
            }
            if (res.length() == 0) {
                res.append(ch);
                vis[ch] = true;
            } else {
                while (res.length() > 0 && ch < res.charAt(res.length() - 1)
                       && count[res.charAt(res.length() - 1)] > 0) {
                    vis[res.charAt(res.length() - 1)] = false;
                    res.deleteCharAt(res.length() - 1);
                }
                res.append(ch);
                vis[ch] = true;
            }
        }
        return res.toString();
    }

    public void main() {
        String s = "bcabc";
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters(s));
    }

    public static void main(String[] args) {
        new RemoveDuplicateLetters().main();
    }
}
