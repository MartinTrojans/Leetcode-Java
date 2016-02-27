import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean exist(char[][] board, String word) {
    	int m = board.length;
    	if (m == 0)	return false;
    	int n = board[0].length;
        Set<Integer> record = new HashSet<Integer>();
        for (int i = 0; i < m; i++)
        	for (int j = 0; j < n; j++)
        		if (backtracking(board, word, 0, i, j, record))	return true;
        return false;
    }
    
    private boolean backtracking(char[][] board, String word, int index, int i, int j, Set<Integer> record) {
    	if (board[i][j] == word.charAt(index) && !record.contains(i*board[0].length+j)){
    		if (index == word.length()-1)	return true;
    		boolean res = false;
    		record.add(i*board[0].length+j);
    		if (i-1>=0)	res |= backtracking(board, word, index+1, i-1, j, record);
    		if (!res && i+1<board.length) res |= backtracking(board, word, index+1, i+1, j, record);
    		if (!res && j-1>=0)	res |= backtracking(board, word, index+1, i, j-1, record);
    		if (!res && j+1<board[0].length) res |= backtracking(board, word, index+1, i, j+1, record);
    		record.remove(i*board[0].length+j);
    		return res;
    	}
    	return false;
    }
}