

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int sum = 15;
		int n = nums.length;

		Map<Integer, List<Pair>> map = new HashMap<>();

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int val = sum - (nums[i] + nums[j]);

				if (map.containsKey(val)) {
					for (Pair pair : map.get(val)) {
						int x = pair.x;
						int y = pair.y;

						if ((x != i && x != j) && (y != i && y != j)) {
							System.out.println("Found: " + nums[i] + ", " + nums[j] + ", " + nums[x] + ", " + nums[y]);
							return;
						}
					}
				}

				map.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
				map.get(nums[i] + nums[j]).add(new Pair(i, j));
			}
		}
	}
}