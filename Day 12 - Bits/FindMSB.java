

import java.util.Scanner;

public class FindMSB {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int k = (int) (Math.log(n) / Math.log(2));
		System.out.println(1 << k);
	}
}