

import java.util.ArrayList;

public class Stack {
	ArrayList<Integer> stack;
	int top;
	int size;

	Stack(int size) {
		this.size = size;
		stack = new ArrayList<Integer>(size);
		top = -1;
	}

	public boolean underflow() {
		return top < 0;
	}

	public boolean overflow() {
		return top > size - 1;
	}

	public void push(int val) {
		if (!this.overflow()) {
			++top;
			stack.add(val);
		} else {
			System.out.println("Stack is full");
		}
	}

	public int pop() {
		if (!this.underflow()) {
			int val = stack.get(top);
			stack.remove(top);
			top--;
			return val;
		} else {
			System.out.println("Stack is empty");
		}
		return -1;
	}

	public static void main(String[] args) {
		Stack stack = new Stack(4);
		stack.push(4);
		stack.push(7);
		stack.push(3);
		stack.push(9);
		System.out.println(stack.pop());
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
