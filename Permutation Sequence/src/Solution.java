import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int fac = 1;
        int[] pos = new int[n+1];
    	for (int i = 1; i <= n; i++){
    		nums.add(i);
    		fac *= i;
    	}
    	fac /= n;
    	k -= 1;
    	for (int i = 1; i < n; i++){
    		
    		pos[i] = k / fac;
    		k %= fac;
    		fac /= (n-i);
    	}
    	StringBuilder res = new StringBuilder();
    	for (int i = 1; i <= n; i++){
    		res.append(nums.remove(pos[i]));
    	}
    	
    	return res.toString();
    }
}