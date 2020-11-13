

public class Queue {

	int[] queue;
	int front, rear;
	int size;

	Queue(int size) {
		this.size = size;
		queue = new int[size];
		this.rear = 0;
		this.front = 0;
	}

	public boolean underflow() {
		return (front >= rear);
	}

	public boolean overflow() {
		return (rear >= size - 1);
	}

	public void enqueue(int val) {
		if (!this.overflow()) {
			queue[rear++] = val;
		} else {
			System.out.println("queue is full");
		}
	}

	public int dequeue() {
		if (!this.underflow()) {
			// System.out.println("front:" + front);
			int val = queue[front];
			queue[front++] = 0;
			return val;
		} else {
			System.out.println("queue is empty");
		}
		return -1;
	}

	public static void main(String[] args) {
		Queue queue = new Queue(10);
		queue.enqueue(4);
		queue.enqueue(7);
		queue.enqueue(3);
		queue.enqueue(9);
		System.out.println(queue.dequeue());
		queue.enqueue(2);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
