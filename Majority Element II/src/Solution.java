import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
    	int count1 = 0, count2 = 0, can1 = 0, can2 = 1;
        
        for (int num: nums){
        	if (num == can1)
        		count1++;
        	else if (num == can2)
        		count2++;
        	else if (count1 == 0){
        		can1 = num;
        		count1 = 1;
        	}
        	else if (count2 == 0){
        		can2 = num;
        		count2 = 1;
        	}
        	else{
        		count1--;
        		count2--;
        	}
        }
        count1 = 0;
        count2 = 0;
        for (int num: nums){
        	if (num == can1)
        		count1++;
        	else if (num == can2)
        		count2++;
        }
        
        if (count1 > nums.length / 3)
        	res.add(can1);
        if (count2 > nums.length / 3 && can1 != can2)
        	res.add(can2);
        
        return res;
    }
}