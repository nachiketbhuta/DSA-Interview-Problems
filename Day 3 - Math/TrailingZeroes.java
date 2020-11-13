

import java.util.Scanner;

public class TrailingZeroes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int ans = 0;
		while (n > 0) {
			int temp = n / 5;
			ans += temp;
			n = temp;
		}
		System.out.println(ans);
	}
}