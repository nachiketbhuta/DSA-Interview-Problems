

import java.util.Stack;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int a[] = { 9, 7, 2, 4, 6, 8, 2, 1, 5 };
		int n = a.length;
		int k = 3;

		int[] maxUpto = new int[n];

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		for (int i = 1; i < n; i++) {
			while (!stack.empty() && a[stack.peek()] < a[i]) {
				maxUpto[stack.peek()] = i - 1;
				stack.pop();
			}
			stack.push(i);
		}

		while (!stack.empty()) {
			maxUpto[stack.peek()] = n - 1;
			stack.pop();
		}

		int j = 0;
		for (int i = 0; i <= n - k; i++) {
			while (j < i || maxUpto[j] < i + k - 1)
				j++;
			System.out.print(a[j] + " ");
		}
	}
}
