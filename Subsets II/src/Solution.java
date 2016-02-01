import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * input: An array like [1, 2, 2]
 * output: return all subsets and no duplicate
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	quicksort(nums, 0, nums.length-1);
    	//Arrays.sort(nums);
    	List<List<Integer>> firstres = subsets(nums);
    	Set<List<Integer>> temp = new HashSet<List<Integer>>();
    	for(List<Integer> tempsub: firstres){
			temp.add(tempsub);
    	}
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for(List<Integer> tempsub: temp){
			res.add(tempsub);
		}
    	List<Integer> emp = new ArrayList<Integer>();
    	res.add(emp);
    	
        return res;
    }
    
    private List<List<Integer>> subsets(int[] nums){
    	List<List<Integer>> thisres = new ArrayList<List<Integer>>();
    	int l = nums.length;
    	if (l == 0)
    		return thisres;
    	if (l == 1){
    		List<Integer> tempres = new ArrayList<Integer>();
    		tempres.add(nums[0]);
    		thisres.add(tempres);
    		return thisres;
    	}
    	for(int i = 0; i < l; i++){
    		List<Integer> thisele = new ArrayList<Integer>();
    		thisele.add(nums[i]);
    		thisres.add(thisele);
			int[] des = new int[l-i-1];
			if (l-i-1 != 0){
				System.arraycopy(nums, i+1, des, 0, l-i-1);
			}
    		for(List<Integer> tempsub: subsets(des)){
    			tempsub.add(0, nums[i]);
    			thisres.add(tempsub);
    		}
    		
    	}
    	
    	return thisres;
    }
    
    private void quicksort(int[] nums, int low, int high){
    	if (low < high){
    		int pivot = partition(nums, low, high);
    		quicksort(nums, low, pivot-1);
    		quicksort(nums, pivot+1, high);
    	}
    }
    
    private int partition(int[] nums, int low, int high){
    	int pivot = nums[low];
    	while(low < high){
    		while(low<high && nums[high]>=pivot)
    			high--;
    		nums[low] = nums[high];
    		while(low<high && nums[low]<=pivot)
    			low++;
    		nums[high] = nums[low];
    	}
    	nums[low] = pivot;
    	return low;
    }
}

/*
 * public static void dfs(int[] S, int start, int len, ArrayList<Integer> item,ArrayList<ArrayList<Integer>> res){
        if(item.size()==len){
            if(!res.contains(item))
                res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start; i<S.length;i++){
            item.add(S[i]);
            dfs(S, i+1, len, item, res);
            item.remove(item.size()-1);
        }

    }
    
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if(S.length==0||S==null)
            return res;
        
        Arrays.sort(S);
        for(int len = 1; len<= S.length; len++)
            dfs(S,0,len,item,res);
            
        res.add(new ArrayList<Integer>());
        
        return res;
    }
 */