import java.util.*;
public class NQueen {
    public static List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> pos = new HashSet<>();
        Set<Integer> neg = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        char[][] empty = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                empty[i][j] = '.';
            }
        }
        backtrack(result, n, empty, col, pos, neg, 0);
        return result;
    }
    public static void backtrack(List<List<String>> result, int n, char[][] empty,  Set<Integer> col,  Set<Integer> pos,  Set<Integer> neg, int index){
        if(index == n){
            List<String> temp = new ArrayList<>();
            for(char[] row:empty){
                temp.add(String.valueOf(row));
            }
            result.add(temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!col.contains(i)&&!pos.contains(i+index)&&!neg.contains(i-index)){
                col.add(i);
                pos.add(i+index);
                neg.add(i-index);
                empty[index][i]='Q';
                backtrack(result, n, empty, col, pos, neg, index+1);
                col.remove(i);
                pos.remove(i+index);
                neg.remove(i-index);
                empty[index][i] = '.';
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = solveNQueens(n);
        for (List<String> current: ans) {
            System.out.println(current);
        }
    }
}