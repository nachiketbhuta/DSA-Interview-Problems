

import java.util.Scanner;

public class CountTotalSetBits {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();

		int i = 0;
		int ans = 0;

		while ((1 << i) <= n) {
			boolean k = false;
			int change = 1 << i;

			for (int j = 0; j <= n; j++) {
				if (k == true)
					ans++;

				if (change == 1) {
					k = !k;
					change = 1 << i;
				} else {
					change--;
				}
			}

			i++;
		}
		System.out.println("Total Set Bits: " + ans);
	}
}