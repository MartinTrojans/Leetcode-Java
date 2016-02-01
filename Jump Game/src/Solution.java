
public class Solution {
	/*
    public boolean canJump(int[] nums) {
        int l = nums.length;
        if (nums[0] == 0 && l > 1)
        	return false;
        int cur = 0;
        int temp = nums[0];
        int step = nums[0];
        int max = nums[0];
        int tempcur = 0;
        
        while (cur + step < l-1){
        	for (int i = 1; i <= step; i++){
        		temp = cur + i + nums[cur + i];
        		if (temp >= max){//current max greedy value
        			max = temp;
        			if (max >= l)
        				return true;
        			tempcur = cur + i;
        		}
        	}
        	if (cur == tempcur)
        		return false;
        	cur = tempcur;
        	step = nums[cur];
        }
        
        if (max >= l-1)
        	return true;
        else
        	return false;
    }
    */
    public boolean canJump(int[] nums) {
        if(nums.length <= 1)
            return true;
     
        int max = nums[0]; //max stands for the largest index that can be reached.
     
        for(int i=0; i<nums.length; i++){
            //if not enough to go to next
            if(max <= i && nums[i] == 0) 
                return false;
     
            //update max    
            if(i + nums[i] > max){
                max = i + nums[i];
            }
     
            //max is enough to reach the end
            if(max >= nums.length-1) 
                return true;
        }
     
        return false;    
    }
}