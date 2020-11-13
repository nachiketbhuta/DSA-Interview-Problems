

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		String roman = "LXXIX"; // 79
		int ans = 0, p = 0;
		for (int i = roman.length() - 1; i >= 0; i--) {
			int curr = map.get(roman.charAt(i));
			if (curr < p)
				ans -= curr;
			else
				ans += curr;
			p = curr;
		}
		System.out.println(ans);
	}
}
