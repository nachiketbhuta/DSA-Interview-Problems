import java.util.*;

public class PalindromePartitioning {
    public static  List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        find(ans, s, new ArrayList());
        return ans;
    }
    
    public static void find(List<List<String>> ans, String s, List<String> current) {
        if (s.length() == 0) {
            ans.add(new ArrayList(current));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);
            if (isPalindrome(left)) {
                current.add(left);
                find(ans, s.substring(i + 1), current);
                current.remove(current.size() - 1);
            }
        }
    }
    
    public static boolean isPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        if (l == h) return true;
        
        while (l < h) {
            if (s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> ans = partition(s);

        for (List<String> curr: ans) {
            System.out.println(curr);
        }
    }
}