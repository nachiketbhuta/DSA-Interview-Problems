

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	static class Node {
		int time;
		int x, y;

		public Node(int time, int x, int y) {
			this.time = time;
			this.x = x;
			this.y = y;
		}
	}

	public static boolean isValid(int i, int j, int n, int m) {
		if (i >= 0 && i < n && j >= 0 && j < m)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

		int n = grid.length;
		int m = grid[0].length;
		boolean visited[][] = new boolean[n][m];

		Queue<Node> queue = new LinkedList<Node>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Node(0, i, j));
					visited[i][j] = true;
				}
			}
		}

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		int universalTime = -1;

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (isValid(nx, ny, n, m) && !visited[nx][ny]) {
					if (grid[nx][ny] == 1) {
						grid[nx][ny] = 2;
						visited[nx][ny] = true;
						queue.add(new Node(current.time + 1, nx, ny));
						universalTime = current.time + 1;
					} else {
						visited[nx][ny] = true;
					}
				}
			}
		}

		boolean notPssble = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					notPssble = true;
					break;
				}
			}
			if (notPssble)
				break;
		}

		if (notPssble)
			System.out.println(-1);
		else
			System.out.println(universalTime);
	}
}
