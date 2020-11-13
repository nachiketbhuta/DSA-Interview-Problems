

import java.util.Scanner;

public class ReverseWords {
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] split = s.split(" ");
		String[] ans = new String[split.length];
		for (int i = 0; i < split.length; i++) {
			ans[i] = reverse(split[i]);
		}

		for (String a : ans)
			System.out.print(a + " ");
	}
}
