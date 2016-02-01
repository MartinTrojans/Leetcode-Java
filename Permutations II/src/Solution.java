import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	return backtracing(nums, 0);
    }
    
    private List<List<Integer>> backtracing(int[] nums, int index) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	HashSet<List<Integer>> tres = new HashSet<List<Integer>>();
    	int len = nums.length;
    	
    	if (index >= len){
    		return res;
    	}
    	
    	if (index == len - 1){
    		List<Integer> tempres = new ArrayList<Integer>();
    		tempres.add(nums[index]);
    		res.add(tempres);
    		return res;
    	}
    	
    	for (List<Integer> list: backtracing(nums, index+1)){
    		for (int i = 0; i <= list.size(); i++){
    			List<Integer> tempres = new ArrayList<Integer>(list);
    			tempres.add(i, nums[index]);
    			tres.add(tempres);
    		}
    	}
    
    	res.addAll(tres);
    	return res;
    }
}