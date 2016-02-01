import java.util.List;
import java.util.ArrayList;

/*
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	return dp(root, sum, res);
    }
    
    private List<List<Integer>> dp(TreeNode root, int sum, List<Integer> cur){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
        	return null;
        if (root.left == null && root.right == null){
        	if (root.val == sum){
        		cur.add(root.val);
        		res.add(cur);
        		return res;
        	}
        	else{
        		return res;
        	}
        }
        if (root.left != null){
        	for (List<Integer> ele: dp(root.left, sum-root.val, cur)){
            	if (ele != null){
            		ele.add(0, root.val);
            		res.add(ele);
            	}
            }
        }
        if (root.right != null){
	        for (List<Integer> ele: dp(root.right, sum-root.val, cur)){
	        	if (ele != null){
	        		ele.add(0, root.val);
	        		res.add(ele);
	        	}
	        }
        }
        
        return res;
    }
}
*/

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<Integer> cur = new ArrayList<Integer>();
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	dp(root, sum, cur, res);
    	
    	return res;
    }
    
    private void dp(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res){
    	if (root == null)
    		return;
    	//preorder dfs
    	
    	sum -= root.val;
    	if (root.left == null && root.right == null){
    		if (sum == 0){
    			cur.add(root.val);
    			List<Integer> tempres = new ArrayList<Integer>();
    			tempres.addAll(cur);
    			res.add(tempres);
    			cur.remove(cur.size() - 1);
    		}
    		return;
    	}
    	cur.add(root.val);
    	if (root.left != null){
    		dp(root.left, sum, cur, res);
    	}
    	if (root.right != null){
    		dp(root.right, sum, cur, res);
    	}
    	cur.remove(cur.size() - 1);
    }
}