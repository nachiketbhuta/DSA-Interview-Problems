import java.util.*;

public class FloodFill {
    static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    public static boolean isValid(int[][] screen, int i, int j, int n, int m, int a, int b) {
		if (i >= 0 && i < n && j >= 0 && j < m && screen[i][j] != b && screen[i][j] == a)
			return true;
		return false;
    }

    public static int[][] floodFill(int[][] screen, int n, int m, int x, int y, int prevColor, int newColor) {
        boolean visited[][] = new boolean[n][m];

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(x, y));
        screen[x][y] = newColor;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int posX = current.x;
            int posY = current.y;

            if (isValid(screen, posX + 1, posY, n, m, prevColor, newColor)) {
                screen[posX + 1][posY] = newColor;
                queue.add(new Node(posX + 1, posY));
            }
            if (isValid(screen, posX - 1, posY, n, m, prevColor, newColor)) {
                screen[posX - 1][posY] = newColor;
                queue.add(new Node(posX - 1, posY));
            }
            if (isValid(screen, posX, posY + 1, n, m, prevColor, newColor)) {
                screen[posX][posY + 1] = newColor;
                queue.add(new Node(posX, posY + 1));
            }
            if (isValid(screen, posX, posY - 1, n, m, prevColor, newColor)) {
                screen[posX][posY - 1] = newColor;
                queue.add(new Node(posX, posY - 1));
            }
        }

        return screen;
    }
    
    public static void main(String[] args) {
        int[][] screen = { 
            {1, 1, 1, 1, 1, 1, 1, 1},  
            {1, 1, 1, 1, 1, 1, 0, 0},  
            {1, 0, 0, 1, 1, 0, 1, 1},  
            {1, 2, 2, 2, 2, 0, 1, 0},  
            {1, 1, 1, 2, 2, 0, 1, 0},  
            {1, 1, 1, 2, 2, 2, 2, 0},  
            {1, 1, 1, 1, 1, 2, 1, 1},  
            {1, 1, 1, 1, 1, 2, 2, 1}
        };

        int n = screen.length;
        int m = screen[0].length;

        int x = 4, y = 4;
        int prevColor = screen[x][y];
        int newColor = 3;

        screen = floodFill(screen, n, m, x, y, prevColor, newColor);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}