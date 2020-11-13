

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {

	static class Activity {
		int start, finish;
		int id;

		Activity(int id, int start, int finish) {
			this.id = id;
			this.start = start;
			this.finish = finish;
		}

		@Override
		public String toString() {
			return "[" + this.id + ", " + this.start + ", " + this.finish + "]";
		}
	}

	public static void main(String[] args) {
		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] finish = { 2, 4, 6, 7, 9, 9 };

		int n = start.length;

		List<Activity> activities = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			activities.add(new Activity(i + 1, start[i], finish[i]));
		}

		Collections.sort(activities, (a, b) -> {
			return a.finish - b.finish;
		});

		Activity first = activities.get(0);
		System.out.println(first);
		for (int i = 1; i < n; i++) {
			if (activities.get(i).start >= first.finish) {
				System.out.println(activities.get(i));
				first = activities.get(i);
			}
		}
	}
}