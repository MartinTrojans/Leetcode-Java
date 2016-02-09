import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	/*
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtracing(candidates, target, 0);
    }
    
    public List<List<Integer>> backtracing(int [] candidates, int target, int left){
    	HashSet<List<Integer>> tres = new HashSet<List<Integer>>();
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	int right = candidates.length-1;
    	
    	if (left > right){
    		return res;
    	}
    	if (target < candidates[left]){
    		return res;
    	}
    	if (target == candidates[left]){
			List<Integer> list = new ArrayList<Integer>();
			list.add(candidates[left]);
			res.add(list);
			return res;
		}
    	if (left == right){
    		return res;
    	}
    	
    	for (int i = left; i <= right; i++){
    		for (List<Integer> list: backtracing(candidates, target-candidates[i], i+1)){
    			list.add(0, candidates[i]);
    			tres.add(list);
    		}
    		for (List<Integer> list: backtracing(candidates, target, i+1)){
    			tres.add(list);
    		}
    	}
    	
    	res.addAll(tres);
    	return res;
    }
    */
	public static ArrayList<List<Integer>> combinationSum2(int[] candidates, int target) {  
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();  
        ArrayList<Integer> item = new ArrayList<Integer>();
        if(candidates == null || candidates.length==0)  
            return res; 
            
        Arrays.sort(candidates);  
        boolean [] visited = new boolean[candidates.length];
        helper(candidates,target, 0, item ,res, visited);  
        return res;  
    }  
    
    private static void helper(int[] candidates, int target, int start, List<Integer> item,   
    ArrayList<List<Integer>> res, boolean[] visited){  
        if(target<0)  
            return;  
        if(target==0){  
            res.add(new ArrayList<Integer>(item));  
            return;
        }
        
        for(int i=start;i<candidates.length;i++){
            if(!visited[i]){
                if(i>0 && candidates[i] == candidates[i-1] && visited[i-1]==false)//deal with dupicate
                    continue;  
                item.add(candidates[i]);
                visited[i]=true;
                int newtarget = target - candidates[i];
                helper(candidates,newtarget,i+1,item,res,visited);  
                visited[i]=false;
                item.remove(item.size()-1);  
            }
        }  
    }
}