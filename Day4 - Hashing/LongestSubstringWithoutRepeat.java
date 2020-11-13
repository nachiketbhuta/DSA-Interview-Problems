

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubstringWithoutRepeat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = "geeksforgeeks";
		int n = s.length();

		int ans = 0;
		int[] last = new int[256];
		Arrays.fill(last, -1);

		int i = 0;

		for (int j = 0; j < n; j++) {
			i = Math.max(i, last[s.charAt(j)] + 1);
			ans = Math.max(ans, j - i + 1);
			last[s.charAt(j)] = j;
		}

		System.out.println("Length: " + ans);
	}
}