

import java.util.Stack;

public class LargestAreaUnderHistogram {

	public static void main(String[] args) {
		int[] a = { 4, 5, 6, 2, 3, 7 };

		Stack<Integer> stack = new Stack<Integer>();
		int n = a.length;
		int ans = 0;

		int i = 0;
		while (i < n) {
			if (stack.empty() || a[i] >= a[stack.peek()])
				stack.push(i++);
			else {
				int top = stack.pop();
				int area = a[top] * (stack.empty() ? i : i - stack.peek() - 1);
				ans = Math.max(ans, area);
			}
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			int area = a[top] * (stack.empty() ? i : i - stack.peek() - 1);
			ans = Math.max(ans, area);
		}
		System.out.println(ans);
	}
}
