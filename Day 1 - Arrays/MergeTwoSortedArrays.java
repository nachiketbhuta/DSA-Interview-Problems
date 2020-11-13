


public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int[] a = { 1, 5, 9, 10, 15, 20 };
		int[] b = { 2, 3, 8, 13 };

		int n = a.length;
		int m = b.length;

		for (int i = m - 1; i >= 0; i--) {
			int j, last = a[n - 1];
			for (j = n - 2; j >= 0 && a[j] > b[i]; j--)
				a[j + 1] = a[j];

			if (j != n - 2 || last > b[i]) {
				a[j + 1] = b[i];
				b[i] = last;
			}
		}

		System.out.print("A: ");
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();

		System.out.print("B: ");
		for (int i : b)
			System.out.print(i + " ");
		System.out.println();
	}
}