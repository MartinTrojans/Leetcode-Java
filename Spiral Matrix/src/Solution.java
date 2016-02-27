import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0)	return res;
        int n = matrix[0].length;
        int direction = 0;//0right, 1down, 2left, 3up
        int i = 0, j = 0;//position
        int c0 = 1, c1 = 1, c2 = 0, c3 = 1;//row and column limit

        while (c0 + c2 - 1 <= n && c1 + c3 - 1 <= m) {
        	res.add(matrix[i][j]);
        	switch (direction) {
        	case 0:
        		if (j == n-c0){
        			direction = (direction+1) % 4;
        			c0++;
        			res.remove(res.size()-1);
        		}
        		else
        			j++;
        		break;
        	case 1:
        		if (i == m-c1){
        			direction = (direction+1) % 4;
        			c1++;
        			res.remove(res.size()-1);
        		}
        		else
        			i++;
        		break;
        	case 2:
        		if (j == c2){
        			direction = (direction+1) % 4;
        			c2++;
        			res.remove(res.size()-1);
        		}
        		else
        			j--;
        		break;
        	case 3:
        		if (i == c3){
        			direction = (direction+1) % 4;
        			c3++;
        			res.remove(res.size()-1);
        		}
        		else
        			i--;
        		break;
        	}
        }
        res.add(matrix[i][j]);
        
        return res;
    }
}