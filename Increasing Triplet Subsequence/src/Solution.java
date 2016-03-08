
public class Solution {
    public boolean increasingTriplet(int[] nums) {
    	int l = nums.length;
    	if (l < 3)	return false;
    	int min = nums[0];
    	int secmin = Integer.MAX_VALUE;
    	
    	for (int i = 1; i < l; i++) {
    		if (nums[i] > secmin)	return true;
    		else if (nums[i] < min) min = nums[i];
    		else if (nums[i] < secmin)	secmin = nums[i];
    	}
    	return false;
    }
}