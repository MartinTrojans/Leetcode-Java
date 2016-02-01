import java.util.HashMap;

public class Solution {
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
        	for (int j = i+1; j < nums.length; j++){
        		if (nums[i] + nums[j] == target){
        			int[] res = {i+1, j+1};
        			return res;
        		}
        			
        	}
		return null;
    }
    
    public int[] twoSum(int[] nums, int target){
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] res = new int[2];
    	
    	for (int i = 0; i < nums.length; i++){
    		if (map.containsKey(nums[i])){
    			res[0] = map.get(nums[i]) + 1;
    			res[1] = i+1;
    			break;
    		}
    		else{
    			map.put(target-nums[i], i);
    		}
    	}
    	
    	return res;
    }
}