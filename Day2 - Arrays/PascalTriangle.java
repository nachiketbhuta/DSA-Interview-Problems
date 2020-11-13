
public class PascalTriangle {
	public static void main(String[] args) {
		int n = 10;
		for (int line = 1; line <= n; line++) {
			int c = 1;

			for (int i = 1; i <= line; i++) {
				System.out.print(c + " ");
				c = c * (line - i) / i;
			}

			System.out.println();
		}
	}
}