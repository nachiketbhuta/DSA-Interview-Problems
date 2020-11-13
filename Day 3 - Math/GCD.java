

import java.util.Scanner;

public class GCD {

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		System.out.println("GCD: " + gcd(x, y));
	}
}