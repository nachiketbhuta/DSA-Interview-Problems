

import java.util.Scanner;

public class PowerInLogN {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		int ans = 1;
		while (y > 0) {
			if (y % 2 == 1) {
				ans *= x;
			}
			x *= x;
			y >>= 1;
		}

		System.out.println(ans);
	}
}