import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word: wordDict) {
                int remain = i - word.length();
                
                if (remain >= 0 && dp[remain] == true && s.substring(remain, remain+word.length()).equals(word)) {
                    dp[i] = true;
                    continue;
                }
            }
            
            dp[i] = (dp[i] == true) ? true : false;
        }
        
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();

        wordDict.add("leet");
        wordDict.add("code");

        if (wordBreak(s, wordDict)) {
            System.out.println("S can be segmented into one or more dictionary words");
        } else {
            System.out.println("S cannot be segmented into one or more dictionary words");
        }
    }
}