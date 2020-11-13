import java.util.Arrays;

public class MatrixMedian {

	public static int median(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		
		int req = (n * m + 1) / 2;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			min = Math.min(min, mat[i][0]);
			max = Math.max(max, mat[i][m-1]);
		}

		while (min < max) {
			int mid = min + (max - min) / 2;
			int place = 0;
			for (int i = 0; i < n; i++) {
				int get = Arrays.binarySearch(mat[i], mid);

				if (get < 0) {
					get = Math.abs(get) - 1;
				}
				else {
					while (get < mat[i].length && mat[i][get] == mid) 
						get++;
				}

				place += get;
			}

			if (place < req) min = mid + 1;
			else max = mid;
		}

		return min;
	}

	public static void main(String[] args) {
		int[][] mat = {
			{1, 3, 5},
			{2, 6, 9},
			{3, 6, 9}
		};

		int ans = median(mat);
		System.out.println(ans);
	}
}