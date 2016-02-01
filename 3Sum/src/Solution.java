import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	int l = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> tres = new HashSet<List<Integer>>();
        
        if (l < 3)
    		return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < l-2; i++){
        	int k = l-1;
        	for (int j = i+1; j < l; j++){
        		while (j < k){
        			int sum = nums[i] + nums[j] + nums[k];
        			if (sum == 0){
        				List<Integer> tempres = new ArrayList<Integer>();
        				tempres.add(nums[i]);
        				tempres.add(nums[j]);
        				tempres.add(nums[k]);
        				tres.add(tempres);
        				while (j < k && nums[j] == tempres.get(1)){
        					j++;
        				}
        				k--;
        			}
        			else if (sum > 0){
        				k--;
        			}
        			else{
        				j++;
        			}
        			
        		}
        	}
        }
        res.addAll(tres);
        
        return res;
    }
}