

import java.util.Arrays;

public class FractionalKnapsack {

	static class Item {
		int value, weight, id;
		Double cost;

		Item(int id, int weight, int value) {
			this.id = id;
			this.weight = weight;
			this.value = value;
			this.cost = new Double(value / weight);
		}

	}

	public static void main(String[] args) {
		int[] weights = { 10, 40, 20, 30 };
		int[] values = { 60, 40, 100, 120 };
		int W = 50;
		int n = 4;

		Item[] items = new Item[n];

		for (int i = 0; i < n; i++) {
			items[i] = new Item(i, weights[i], values[i]);
		}

		Arrays.sort(items, (a, b) -> {
			return b.cost.compareTo(a.cost);
		});

		double ans = 0d;

		for (Item item : items) {
			int weight = item.weight;
			int value = item.value;

			if (W - weight >= 0) {
				ans += value;
				W -= weight;
			} else {
				double fraction = ((double) W / (double) weight);
				ans += (value * fraction);

				W = (int) (W - (weight * fraction));
				break;
			}
		}

		System.out.println(ans);
	}
}