
public class Solution {
    public int minPatches(int[] nums, int n) {
        int total = 1; //total is the upper bound of the sum
        int count = 0;
        int index = 0;
        int len = nums.length;
        
        while (total <= n) {
        	if (index < len && nums[index] <= total){
        		total += nums[index++];
        	}
        	else{
        		total <<= 1;
        		count++;
        		if (total < 0)
        			break;
        	}
        }
        
        
        return count;
    }
}