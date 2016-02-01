
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lr = obstacleGrid.length;
        if (lr == 0)
        	return 0;
        int lc = obstacleGrid[0].length;
    	int[][] dp = new int[lr][lc];
    	if (obstacleGrid[0][0] == 1){
    		return 0;
    	}
    	dp[0][0] = 1;
    	
    	for (int i = 1; i < lr; i++){
    		if (obstacleGrid[i][0] == 1)
    			break;
    		dp[i][0] = 1;
    	}
    	for (int i = 1; i < lc; i++){
    		if (obstacleGrid[0][i] == 1)
    			break;
    		dp[0][i] = 1;
    	}
    	
    	for (int i = 1; i < lr; i++)
    		for (int j = 1; j < lc; j++){
    			if(obstacleGrid[i][j] == 1)
    				continue;
    			dp[i][j] = dp[i-1][j] + dp[i][j-1];
    		}
    	
        return dp[lr-1][lc-1];
    }
}
