
public class Solution {
	static int lr = 0;
	static int lc = 0;
	static int[][] longest;
    public int longestIncreasingPath(int[][] matrix) {
        lr = matrix.length;
        if(lr == 0){
        	return 0;
        }
        lc = matrix[0].length;
        longest = new int[lr][lc];
    	int temp = 0, max = 0;
    	for(int i=0; i<lr; i++)
    		for(int j=0; j<lc; j++){
    			temp = bt(matrix, i, j);
    			if(temp > max){
    				max = temp;
    			}
    		}
    	return max;
    }
    
    private int bt(int[][] matrix, int row, int column){
    	int max = 1, temp = 0;
    	for(int i = -1; i < 2; i+=2){
			if(row+i > -1 && row+i < lr){
				if(matrix[row+i][column] > matrix[row][column]){
    				temp = longest[row+i][column];
    				if(temp == 0){
        				longest[row+i][column] = bt(matrix, row+i, column);
        				temp = longest[row+i][column];
        			}
    				if(temp+1>max){
    					max = temp+1;
    				}
				}
				
			}
			if(column+i > -1 && column+i < lc){
				if(matrix[row][column+i] > matrix[row][column]){
    				temp = longest[row][column+i];
    				if(temp == 0){
        				longest[row][column+i] = bt(matrix, row, column+i);
        				temp = longest[row][column+i];
        			}
    				if(temp+1>max){
    					max = temp+1;
    				}
				}
			}	
    	}
    	
    	longest[row][column] = max;
    	return longest[row][column];
    }
}
