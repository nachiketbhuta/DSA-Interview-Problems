

import java.util.Stack;

public class BalancedParentheses {

	public static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
				continue;
			}

			if (stack.isEmpty())
				return false;

			char top = stack.pop();

			switch (top) {
			case ')':
				if (top == ']' || top == '}')
					return false;
				break;
			case ']':
				if (top == '}' || top == ')')
					return false;
				break;
			case '}':
				if (top == ')' || top == ']')
					return false;
				break;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isBalanced("(())[{}]"));
		System.out.println(isBalanced("(())[{}}]"));
	}
}
