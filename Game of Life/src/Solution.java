
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0)
        	return;
        int n = board[0].length;
        
        //int[][] temp = new int[m][n];
        
        
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++){
        		int count = 0;
        		for (int p = -1; p < 2; p++)
        			for (int q = -1; q < 2; q++){
        				if (i+p>=0 && i+p<m && j+q>=0 && j+q<n && !(p==0 && q==0)){
        					if ((board[i+p][j+q] & 1) == 1)
        						count++;
        				}
        			}
        		
        		if ((board[i][j] & 1) == 0 && count == 3){
        			//temp[i][j] = 1;
        			board[i][j] = 2;
        		}
        		else if ((board[i][j] & 1) == 1 && count <=3 && count >= 2){
        				board[i][j] = 3;
        			
        		}
        	}
        }
        
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++){
        		//board[i][j] = temp[i][j];
        		board[i][j] >>= 1;
        	}
        }
    }
}