

import java.util.Scanner;

public class Divide {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();

		int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

		a = Math.abs(a);
		b = Math.abs(b);

		long q = 0, temp = 0;

		for (int i = 31; i >= 0; i--) {
			if (temp + (b << i) <= a) {
				temp += (b << i);
				q |= 1L << i;
			}
		}

		long ans = sign * q;
		System.out.println("Answer: " + ans);
	}
}