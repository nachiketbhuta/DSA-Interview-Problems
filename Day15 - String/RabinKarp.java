

public class RabinKarp {

	public static final int ALPHABETS = 26;
	public static final int PRIME = 5381;

	public static void main(String[] args) {
		String text = "AABAABAAC";
		String pattern = "BAA";
		int n = text.length();
		int m = pattern.length();
		int windowHash = 0;
		int patternHash = 0;
		int h = 1;
		for (int i = 0; i < m - 1; i++)
			h = (h * ALPHABETS) % PRIME;

		for (int i = 0; i < m; i++) {
			patternHash = (ALPHABETS * patternHash + pattern.charAt(i)) % PRIME;
			windowHash = (ALPHABETS * windowHash + text.charAt(i)) % PRIME;
		}
		int j = 0;
		for (int i = 0; i <= n - m; i++) {
			if (windowHash == patternHash) {
				for (j = 0; j < m; j++) {
					if (text.charAt(i + j) != pattern.charAt(j))
						break;
				}
				if (j == m) {
					System.out.println("Pattern found at index " + i);
				}
			}

			if (i < n - m) {
				windowHash = (ALPHABETS * (windowHash - text.charAt(i) * h) + text.charAt(i + m)) % PRIME;
				if (windowHash < 0)
					windowHash += PRIME;
			}
		}
	}
}
