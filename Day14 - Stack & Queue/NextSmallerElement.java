

import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		int[] nums = { 11, 13, 21, 3 };

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int next = nums[i];

			if (!stack.isEmpty()) {
				int top = stack.pop();
				while (top > next) {
					System.out.println(top + "-->" + next);
					if (stack.isEmpty())
						break;
					top = stack.pop();
				}

				if (top < next)
					stack.push(top);
			}

			stack.push(next);
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			int next = -1;
			System.out.println(top + "-->" + next);
		}
	}
}
