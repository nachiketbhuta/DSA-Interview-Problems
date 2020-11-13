
public class KMPAlgorithm {

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

	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
//		System.out.println("Hello");
		int[] lps = longestPrefixArray(pattern);
		int i = 0, j = 0;
		int n = text.length();
		int m = pattern.length();

		for (int z : lps) {
			System.out.print(z + " ");
		}

		while (i < n) {
			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Found pattern at " + (i - j));
				j = lps[j - 1];
			} else if (i < n && pattern.charAt(j) == text.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}

}
