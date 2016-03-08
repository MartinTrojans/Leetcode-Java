
public class Solution {
    public int maxProduct(int[] nums) {
    	int l = nums.length;
        int max = nums[0];
        int maxhere = nums[0];
        int minhere = nums[0];
        
        for (int i = 1; i < l; i++) {
        	if (nums[i] >= 0) {
        		maxhere = Math.max(maxhere*nums[i], nums[i]);
        		minhere = Math.min(minhere*nums[i], nums[i]);
        	} else {
        		int temp = maxhere;
        		maxhere = Math.max(minhere*nums[i], nums[i]);
        		minhere = Math.min(temp*nums[i], nums[i]);
        	}
        	max = Math.max(maxhere, max);
        }
        
        return max;
    }
}