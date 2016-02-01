import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int l = nums.length;
        if (l < 3)
        	return 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        
        for (int i = 0; i < l; i++){
        	int j = i + 1;
        	int k = l - 1;
        	
        	while (j < k){
        		int sum = nums[i] + nums[j] + nums[k];
        		if (sum == target)
        			return sum;
        		int diff = Math.abs(sum - target);
        		if (diff < min){
        			min = diff;
        			res = sum;
        		}
        		if (sum > target)
        			k--;
        		else
        			j++;
        	}
        	
        }
        return res;
    }
}