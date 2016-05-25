public class Solution {
    public boolean wordBreakHelp(String s, Set<String> wordDict, Set<String> unMatch) {
        if (s.length() == 0) return true;
        for (int i = 1; i <= s.length(); ++i) {
            String prefixString = s.substring(0, i);
            if (wordDict.contains(prefixString)) {
                String suffixString = (i < s.length()?s.substring(i):"");
                boolean isUnMatch = unMatch.contains(suffixString);
                if (isUnMatch) continue;
                boolean flag = wordBreakHelp(suffixString, wordDict, unMatch);
                if (flag) return true;
                else unMatch.add(suffixString);
            }
        }
        return false;
    }
    public boolean wordBreak(String s, Set<String> wordDict) {
        Set<String> unMatch = new HashSet<String>();
        return wordBreakHelp(s, wordDict, unMatch);
    }
}