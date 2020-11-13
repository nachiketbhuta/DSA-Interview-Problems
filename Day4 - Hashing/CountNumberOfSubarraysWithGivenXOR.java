

import java.util.HashMap;

public class CountNumberOfSubarraysWithGivenXOR {
	public static void main(String[] args) {
		int nums[] = { 4, 2, 2, 6, 4 };
		int n = nums.length;
		int m = 6;

		int ans = 0;
		int[] xor = new int[n];

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		xor[0] = nums[0];

		for (int i = 1; i < n; i++)
			xor[i] = xor[i - 1] ^ nums[i];

		for (int i = 0; i < n; i++) {
			int temp = m ^ xor[i];

			ans = ans + (hashMap.containsKey(temp) == false ? 0 : hashMap.get(temp));

			if (xor[i] == m)
				ans++;

			if (hashMap.containsKey(xor[i]))
				hashMap.put(xor[i], hashMap.get(xor[i]) + 1);
			else
				hashMap.put(xor[i], 1);
		}

		System.out.println("Number of Subarrays: " + ans);
	}
}