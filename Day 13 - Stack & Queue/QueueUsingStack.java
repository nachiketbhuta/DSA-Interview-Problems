

import java.util.Stack;

public class QueueUsingStack {

	static class EnqueueCostly {
		static Stack stack1 = new Stack();
		static Stack stack2 = new Stack();
		static int size;

		EnqueueCostly() {
			size = 0;
		}

		static void enqueue(int val) {
			size++;

			if (stack1.isEmpty()) {
				stack1.add(val);
			} else {
				while (!stack1.isEmpty()) {
					int top = (int) stack1.pop();
					stack2.push(top);
				}
				stack1.add(val);
				while (!stack2.isEmpty()) {
					int top = (int) stack2.pop();
					stack1.push(top);
				}
			}
		}

		static int dequeue() {
			int val = (int) stack1.pop();
			size--;
			return val;
		}
	}

	static class DequeueCostly {
		static Stack stack1 = new Stack();
		static Stack stack2 = new Stack();
		static int size;

		DequeueCostly() {
			size = 0;
		}

		static void enqueue(int val) {
			size++;
			stack1.push(val);

		}

		static int dequeue() {
			while (stack1.size() >= 2) {
				int top = (int) stack1.pop();
				stack2.push(top);
			}
			int val = (int) stack1.pop();
			while (!stack2.isEmpty()) {
				int top = (int) stack2.pop();
				stack1.push(top);
			}
			size--;
			return val;
		}
	}

	public static void main(String[] args) {
		EnqueueCostly pushQueue = new EnqueueCostly();
		pushQueue.enqueue(1);
		pushQueue.enqueue(5);
		pushQueue.enqueue(3);
		System.out.println(pushQueue.dequeue());
		pushQueue.enqueue(2);
		System.out.println(pushQueue.dequeue());

		DequeueCostly popQueue = new DequeueCostly();
		popQueue.enqueue(1);
		popQueue.enqueue(5);
		popQueue.enqueue(3);
		System.out.println(popQueue.dequeue());
		popQueue.enqueue(2);
		System.out.println(popQueue.dequeue());
	}
}
