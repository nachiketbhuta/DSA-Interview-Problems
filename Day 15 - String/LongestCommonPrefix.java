

public class LongestCommonPrefix {
	public static final int ALPHABETS = 26;

	static class TrieNode {
		TrieNode[] childs = new TrieNode[ALPHABETS];
		int wordCount;
		boolean isLeaf;

		public TrieNode() {
			isLeaf = false;
			for (int i = 0; i < ALPHABETS; i++)
				childs[i] = null;
		}
	}

	static TrieNode root;
	static int wordCount;

	static void insert(String key) {
		TrieNode temp = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (temp.childs[index] == null)
				temp.childs[index] = new TrieNode();
			temp = temp.childs[index];
		}
		temp.isLeaf = true;
	}

	static int count(TrieNode node) {
		int cnt = 0;
		for (int i = 0; i < ALPHABETS; i++) {
			if (node.childs[i] != null) {
				cnt++;
				wordCount = i;
			}
		}
		return cnt;
	}

	static String traverse() {
		TrieNode temp = root;
		wordCount = 0;
		String prefix = "";
		while (count(temp) == 1 && !temp.isLeaf) {
			temp = temp.childs[wordCount];
			prefix += (char) (wordCount + 'a');
		}
		return prefix;
	}

	static void constructTrie(String a[], int n) {
		for (int i = 0; i < n; i++)
			insert(a[i]);
	}

	public static void main(String[] args) {
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		int n = arr.length;

		String ans = commonPrefix(arr, n);

		if (ans.length() != 0)
			System.out.println("The longest common prefix is " + ans);
		else
			System.out.println("There is no common prefix");
	}

	public static String commonPrefix(String[] arr, int n) {
		root = new TrieNode();
		constructTrie(arr, n);
		return traverse();
	}
}
