

import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache {

	Set<Integer> cache;
	int capacity;

	LRUCache(int size) {
		this.capacity = size;
		this.cache = new LinkedHashSet<Integer>(size);
	}

	public boolean get(int key) {
		if (!cache.contains(key))
			return false;
		cache.remove(key);
		cache.add(key);
		return true;
	}

	public void refer(int key) {
		if (!get(key))
			put(key);
	}

	public void put(int key) {
		if (cache.contains(key))
			cache.remove(key);
		else if (cache.size() == capacity) {
			int first = cache.iterator().next();
			cache.remove(first);
		}

		cache.add(key);
	}

	public void display() {
		for (int i : cache)
			System.out.print(i + " ");
	}

	public static void main(String[] s) {
		LRUCache ca = new LRUCache(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();
	}
}
