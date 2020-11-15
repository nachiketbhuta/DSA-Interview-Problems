import java.util.*;

public class WordBreak {
    public static void wordBreak(String s, List<String> dictionary) {
        // List<List<String>> ans = new ArrayList();
        dfs(s, dictionary, "");
        // return ans;
    }

    public static void dfs(String s, List<String> dictionary, String curr) {
        if (s.length() == 0) {
            System.out.println(curr + " ");
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0,i);

            if (dictionary.contains(prefix)) {
                dfs(s.substring(i), dictionary, curr  + " " + prefix);
            }
        }
    }
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList(
            "mobile","samsung","sam","sung",
            "man","mango", "icecream","and",
            "go","i","love","ice","cream"
        );

        String s = "iloveicecreamandmango";
        wordBreak(s, dictionary);
        
    }
}