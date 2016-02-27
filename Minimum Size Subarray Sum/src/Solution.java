
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        int temp = 0;
        int startIndex = 0;
        
        for ( int i = 0; i < nums.length; i++ ){
        	 temp += nums[i];
        	 if (temp >= s){
        		 while (temp >= s){
        			 flag = true;
        			 temp -= nums[startIndex++];
        		 }
        		 int len = i - startIndex + 2;
        		 if (len < min)
        			 min = len;
        	 }
        	 
        }
        if (flag)
        	return min;
        else
        	return 0;
    }
}