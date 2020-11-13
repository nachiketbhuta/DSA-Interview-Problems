

import java.util.Stack;

public class MinStack {

	static class Pair {
		int x;
		int min;

		Pair(int x, int min) {
			this.x = x;
			this.min = min;
		}
	}

	Stack<Pair> stack;

	MinStack() {
		stack = new Stack<Pair>();
	}

	public void push(int val) {
		if (!stack.isEmpty()) {
			Pair top = stack.peek();
			int min = Math.min(top.min, val);
			stack.push(new Pair(val, min));
		} else {
			stack.push(new Pair(val, val));
		}
	}

	public int getMin() {
		return stack.peek().min;
	}

	public int pop() {
		return stack.pop().x;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(2);
		minStack.push(1);
		minStack.push(8);
		minStack.push(6);
		System.out.println(minStack.getMin());
	}
}
