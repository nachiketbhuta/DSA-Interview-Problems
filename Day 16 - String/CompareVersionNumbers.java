

import java.util.Scanner;

public class CompareVersionNumbers {

	public static int compareVersion(String v1, String v2) {
		int num1 = 0, num2 = 0;

		for (int i = 0, j = 0; (i < v1.length() || j < v2.length());) {
			while (i < v1.length() && v1.charAt(i) != '.') {
				num1 = num1 * 10 + v1.charAt(i) - 'a';
				i++;
			}

			while (j < v2.length() && v2.charAt(j) != '.') {
				num2 = num2 * 10 + v2.charAt(j) - 'a';
				j++;
			}

			if (num1 > num2)
				return 1;
			if (num2 > num1)
				return -1;

			num1 = num2 = 0;
			i++;
			j++;
		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String v1 = sc.next();
		String v2 = sc.next();

		int ans = compareVersion(v1, v2);

		switch (ans) {
		case -1:
			System.out.println("v2 is greater");
			break;
		case 0:
			System.out.println("v1 and v2 are same");
			break;
		case 1:
			System.out.println("v1 is greater");
			break;
		}

	}
}
