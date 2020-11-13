

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumCoins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int deno[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
		int n = deno.length;

		int num = sc.nextInt();

		List<Integer> ans = new ArrayList<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			while (num >= deno[i]) {
				num -= deno[i];
				ans.add(deno[i]);
			}
		}

		System.out.println("Coins are: ");
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}