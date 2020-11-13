

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingsInRoom {

	static class Meeting {
		int start, finish, id;

		Meeting(int id, int start, int finish) {
			this.id = id;
			this.start = start;
			this.finish = finish;
		}

		@Override
		public String toString() {
			return this.id + " ";
		}
	}

	public static void main(String[] args) {
		int[][] nums = { { 0, 4 }, { 5, 10 }, { 15, 20 } };

		int n = 3;
		List<Meeting> meetings = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			meetings.add(new Meeting(i + 1, nums[i][0], nums[i][1]));
		}

		Collections.sort(meetings, (a, b) -> {
			return a.start - b.start;
		});

		boolean ok = true;

		for (int i = 0; i < n - 1; i++) {
			if (meetings.get(i).finish > meetings.get(i + 1).start) {
				ok = false;
				break;
			}
		}
		System.out.println(ok ? "Can attend all meetings" : "Cannot attend all meetings");
	}
}