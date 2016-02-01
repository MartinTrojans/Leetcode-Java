import java.util.List;

/*
 * @author:Martin
 * input: a 2d array contain integers
 * output: return the minimum sum of the path
 * 
 */

public class Solution{
	public int minimumTotal(List<List<Integer>> triangle){
		int lr = triangle.size();
		int[] min = new int[lr];
		int[] tempmin = new int[lr];
		min[0] = triangle.get(0).get(0);
		for(int i = 1; i < lr; i++){
			tempmin[0] = min[0] + triangle.get(i).get(0);
			tempmin[i] = min[i-1] + triangle.get(i).get(i);
			for(int j = 1; j < i; j++){
				int res1 = min[j-1] + triangle.get(i).get(j);
				int res2 = min[j] + triangle.get(i).get(j);
				if(res1 < res2)
					tempmin[j] = res1;
				else
					tempmin[j] = res2;
			}
			for(int k = 0; k < i+1; k++){
				min[k] = tempmin[k];
			}
		}
		int m = 100000;
		for(int i = 0; i < lr; i++){
			if(min[i] < m)
				m = min[i];
		}
		return m;
	}
}

/*
public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int lr = triangle.size();
		if(lr == 0){
			return 0;
		}
		int lc = triangle.get(lr-1).size();
        int min = 100000;
        for(int i = 0; i < lc; i++){
        	int tmp = dp(triangle, lr-1, i);
        	if(tmp < min)
        		min = tmp;
        }
        return min;
    }
	
	public int dp(List<List<Integer>> triangle, int row, int column){
		if(row == 0){
			return triangle.get(0).get(0);
		}
		int value = triangle.get(row).get(column);
		int size = triangle.get(row-1).size();
		if(column >= size){
			return dp(triangle, row-1, column-1) + value;
		}
		else if(column - 1 < 0){
			return dp(triangle, row-1, column) + value;
		}
		else{
			int res1 = dp(triangle, row-1, column-1) + value;
			int res2 = dp(triangle, row-1, column) + value;
			if(res1 < res2){
				return res1;
			}
			else{
				return res2;
			}
		}
	}
}
*/
