

import java.util.Scanner;

public class ExcelColumnNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		StringBuilder ans = new StringBuilder();
		while (n > 0) {
			int rem = n % 26;
			if (rem == 0) {
				ans.append("Z");
				n = n / 26 - 1;
			} else {
				ans.append((char) ((rem - 1) + 'A'));
				n /= 26;
			}
		}
		System.out.println(ans.reverse());
	}
}