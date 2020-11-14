public class MinimumCharactersForPalindrome {
    public static int[] longestPrefixArray(String pattern) {
		int m = pattern.length();

		int[] lps = new int[m];
		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0)
					len = lps[len - 1];
				else {
					lps[i] = len;
					i++;
				}
			}
		}

		return lps;
    }

    public static int solve(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();

        sb.reverse().append("$").append(reverse);

        int[] lps = longestPrefixArray(sb.toString());
        return s.length() - lps[sb.length() - 1];
    }
    
    public static void main(String[] args) {
        String str = "AACECAAAA";  
        int ans = solve(str);
        System.out.println(ans);  
    }
}