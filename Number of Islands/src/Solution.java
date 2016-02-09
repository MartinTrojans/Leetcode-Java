
public class Solution {
	/*
	int res = 0;
    public int numIslands(char[][] grid) {
        int rl = grid.length;
        if (rl == 0)
        	return 0;
        int cl = grid[0].length;
        int[][] record = new int[rl][cl];
        int[][] visited = new int[rl][cl];
        
        
        for (int i = 0; i < rl; i++) {
        	for (int j = 0; j < cl; j++) {
        		dfsCheck(i, j, grid, record, visited);
        	}
        }
        return res;
    }
    
    private void dfsCheck(int m, int n, char[][] grid, int[][] record, int[][] visited){
    	if (visited[m][n] == 1)
    		return;
    	visited[m][n] = 1;
    	int flag = 0;
    	if (grid[m][n] == '1'){
    		if (record[m][n] == 0){
    			for (int i = -1; i < 2; i++){
        			for (int j = -1; j < 2; j++){
        				if (m+i>=0 && m+i <grid.length && n+j>=0 && n+j<grid[0].length && (i+j == -1 || i+j == 1)){
        					if (record[m+i][n+j] != 0){
        						record[m][n] = record[m+i][n+j];
        						flag = 1;
        					}
        				}
        			}
        		}
    			if (flag == 0)
    				record[m][n] = ++res;
    		}
    		
    		//extension
    		for (int i = -1; i < 2; i++){
    			for (int j = -1; j < 2; j++){
    				if (m+i>=0 && m+i <grid.length && n+j>=0 && n+j<grid[0].length && (i+j == -1 || i+j == 1)){
    					if (grid[m+i][n+j] == '1' && visited[m+i][n+j] == 0)
    						dfsCheck(m+i, n+j, grid, record, visited);
    				}
    			}
    		}
    	}
    }
    */
    private int m, n;
    
    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                
                ans++;
                dfs(grid, i, j);
            }
        }
        return ans;
    }
    
    
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}

