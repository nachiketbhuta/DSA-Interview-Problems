

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingSubintervals {

	static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		int[][] times = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };

		Interval[] intervals = new Interval[4];
		for (int i = 0; i < 4; i++) {
			intervals[i] = new Interval(times[i][0], times[i][1]);
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
			}
		});

		int ind = 0;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[ind].end >= intervals[i].start) {
				intervals[ind].end = Math.max(intervals[ind].end, intervals[i].end);
				intervals[ind].start = Math.min(intervals[ind].start, intervals[i].start);
			} else {
				intervals[ind] = intervals[i];
				ind++;
			}
		}

		System.out.print("The Merged Intervals are: ");
		for (int i = 0; i <= ind; i++) {
			System.out.print("[" + intervals[i].start + "," + intervals[i].end + "]");
		}
		System.out.println();
	}
}