

public class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		int rows = 3;
		int cols = 3;

		boolean firstRow = false, firstCol = false;

		for (int c = 0; c < cols; c++) {
			if (mat[0][c] == 0)
				firstRow = true;
		}

		for (int r = 0; r < rows; r++) {
			if (mat[r][0] == 0)
				firstCol = true;
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == 0) {
					mat[0][j] = 0;
					mat[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (mat[0][j] == 0 || mat[i][0] == 0)
					mat[i][j] = 0;
			}
		}

		if (firstRow == true) {
			for (int i = 0; i < rows; i++)
				mat[0][i] = 0;
		}

		if (firstCol == true) {
			for (int i = 0; i < cols; i++)
				mat[i][0] = 0;
		}

		System.out.println("Output: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}