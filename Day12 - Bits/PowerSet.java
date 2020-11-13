

public class PowerSet {
	public static void main(String[] args) {
		char[] alphas = { 'a', 'b', 'c' };
		int n = alphas.length;
		int mask = (1 << n);

		for (int i = 0; i <= mask; i++) {
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(alphas[j] + " ");
				}
			}
			System.out.println();
		}
	}
}