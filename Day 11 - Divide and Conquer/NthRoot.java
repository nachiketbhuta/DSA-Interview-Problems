
import java.util.Scanner;

public class NthRoot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double x = sc.nextDouble();
		int n = sc.nextInt();

		double low, high;

		if (x >= 0 && x <= 1) {
			low = x;
			high = 1;
		} else {
			low = 1;
			high = x;
		}

		double error = 0.00000001;

		double mid = (low + high) / 2;
		while (Math.abs((Math.pow(mid, n)) - x) >= error) {
			if (Math.pow(mid, n) > x) {
				high = mid;
			} else {
				low = mid;
			}

			mid = (low + high) / 2;
		}
		System.out.println(mid);
	}
}