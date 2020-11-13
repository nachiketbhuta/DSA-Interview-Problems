
public class RotateMatrix {
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		// Transpose the matrix
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[i].length; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[i][j];
				arr[i][j] = temp;
			}
		}

		// Reverse Columns
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0, k = arr[i].length - 1; j < k; j++, k--) {
				int temp = arr[j][i];
				arr[j][i] = arr[k][i];
				arr[k][i] = temp;
			}
		}

		// Print
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}