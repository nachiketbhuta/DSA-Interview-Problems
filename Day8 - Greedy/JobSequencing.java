

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class JobSequencing {

	static class Job {
		int deadline;
		int profit;
		char id;

		Job(char id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public String toString() {
			return "[" + this.id + ", " + this.deadline + ", " + this.profit + "]";
		}
	}

	public static void main(String[] args) {
		char[] id = { 'a', 'b', 'c', 'd', 'e' };
		int[] deadlines = { 2, 1, 2, 1, 3 };
		int[] profits = { 100, 19, 27, 25, 15 };

		int n = 5;
		List<Job> jobs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			jobs.add(new Job(id[i], deadlines[i], profits[i]));
		}

		Collections.sort(jobs, (a, b) -> {
			return (a.profit != b.profit) ? b.profit - a.profit : b.deadline - a.deadline;
		});

		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < n; i++)
			ts.add(i);

		List<Job> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Integer x = ts.floor(jobs.get(i).deadline - 1);

			if (x != null) {
				ans.add(jobs.get(i));
				ts.remove(x);
			}
		}

		System.out.println("Job Selected are: ");
		for (Job job : ans) {
			System.out.println(job);
		}
		System.out.println();
	}
}