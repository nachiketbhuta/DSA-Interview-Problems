

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {
	static class Interval {
		int buy, sell;
	}

	public static void main(String[] args) {
		int[] price = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;

		if (n == 1)
			return;

		int cnt = 0;
		List<Interval> ans = new ArrayList<>();

		int i = 0;
		while (i < n - 1) {
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			if (i == n - 1)
				break;

			Interval e = new Interval();
			e.buy = i++;

			while ((i < n) && (price[i] >= price[i - 1]))
				i++;
			e.sell = i - 1;
			ans.add(e);
			cnt++;
		}

		if (cnt == 0) {
			System.out.println("There is no day when buying the stock will make profit");
		} else {
			for (Interval a : ans)
				System.out.println("Buy on Day: " + a.buy + ", Sell on Day: " + a.sell);
		}
	}
}