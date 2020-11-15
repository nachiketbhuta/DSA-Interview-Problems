import java.util.*;
public class Sudoku {
	static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return this.x + " " + this.y;
        }
    }
    public static char[][] solveSudoku(char[][] board) {
        List<Pair> blank = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.')
                    blank.add(new Pair(i, j));
                else {
                    set.add(board[i][j] + " Row " + i);
                    set.add(board[i][j] + " Col " + j);
                    set.add(board[i][j] + " Box " + i/3 + " " + j/3);
                }
            }
        }
		solve(board, set, blank, 0);
		return board;
    }
    
    public static boolean solve(char[][] board, Set<String> set, List<Pair> blank, int index) {
        if(index == blank.size())
            return true;
        for(char c = '1'; c <= '9'; c++) {
            String isRow = c + " Row " + blank.get(index).x;
            String isCol = c + " Col " + blank.get(index).y;
            String isBox = c + " Box " + (blank.get(index).x)/3 + " " + (blank.get(index).y)/3;
            if(!set.contains(isRow) && !set.contains(isCol) && !set.contains(isBox))
            {
                board[blank.get(index).x][blank.get(index).y] = c;
                set.add(isRow);
                set.add(isCol);
                set.add(isBox);
                if(solve(board, set, blank, index+1)) {
                    return true;
                }
                board[blank.get(index).x][blank.get(index).y] = '.';
                set.remove(isRow);
                set.remove(isCol);
                set.remove(isBox); 
            }
        }
        
        return false;
    }
	public static void main(String[] args) {
		char[][] board = {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};

		char[][] ans = solveSudoku(board);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}