

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	static class PushCostly {
		static Queue queue1 = new LinkedList();
		static Queue queue2 = new LinkedList();
		static int size;

		PushCostly() {
			size = 0;
		}

		static void push(int val) {
			size++;

			if (queue1.isEmpty()) {
				queue1.add(val);
			} else {
				while (!queue1.isEmpty()) {
					int top = (int) queue1.poll();
					queue2.add(top);
				}
				queue1.add(val);
				while (!queue2.isEmpty()) {
					int top = (int) queue2.poll();
					queue1.add(top);
				}
			}
		}

		static int pop() {
			int val = (int) queue1.poll();
			size--;
			return val;
		}
	}

	static class PopCostly {
		static Queue queue1 = new LinkedList();
		static Queue queue2 = new LinkedList();
		static int size;

		PopCostly() {
			size = 0;
		}

		static void push(int val) {
			size++;
			queue1.add(val);

		}

		static int pop() {
			while (queue1.size() >= 2) {
				int top = (int) queue1.poll();
				queue2.add(top);
			}
			int val = (int) queue1.poll();
			while (!queue2.isEmpty()) {
				int top = (int) queue2.poll();
				queue1.add(top);
			}
			size--;
			return val;
		}
	}

	public static void main(String[] args) {
		PushCostly pushStack = new PushCostly();
		pushStack.push(1);
		pushStack.push(5);
		pushStack.push(3);
		System.out.println(pushStack.pop());
		pushStack.push(2);
		System.out.println(pushStack.pop());

		PopCostly popStack = new PopCostly();
		popStack.push(1);
		popStack.push(5);
		popStack.push(3);
		System.out.println(popStack.pop());
		popStack.push(2);
		System.out.println(popStack.pop());
	}
}
