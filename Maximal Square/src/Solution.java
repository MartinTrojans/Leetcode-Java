
public class Solution {
    public int maximalSquare(char[][] matrix) {
    	int m = matrix.length;
    	if (m == 0)	return 0;
    	int n = matrix[0].length;
    	int res = 0;
    	int[][] opt = new int[m+1][n+1];
    	
    	for (int i = 1; i <= m; i++){
    		for (int j = 1; j <= n; j++) {
    			if (matrix[i-1][j-1] == '1') {
    				opt[i][j] = Math.min(opt[i-1][j-1], Math.min(opt[i-1][j], opt[i][j-1])) + 1;
    				res = Math.max(res, opt[i][j]);
    			}
    		}
    	}
    	
    	return res * res;
    }
}