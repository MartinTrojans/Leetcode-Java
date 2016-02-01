/*
 * Input: A binary tree
 * Output: linked list (replace in place)
 * Thinking: dfs, and the order is root, left-child, right-child, and 
 * make the left-child become first right-child of root and make right-child
 * become its next right-child
 */
public class Solution {
    public void flatten(TreeNode root) {
    	if (root == null)
    		return;
        dfs(root);
    }
    
    public TreeNode dfs(TreeNode root){
    	
    	if (root.left == null && root.right == null){
    		return root;
    	}
    	
    	TreeNode left = null;
    	TreeNode right = null;
    	TreeNode preleft = root.left;
    	TreeNode preright = root.right;
    	if (preleft == null){
    		return dfs(preright);
    	}
    	else if(preright == null){
    		root.left = null;
    		root.right = preleft;
    		return dfs(preleft);
    	}
    	else{
    		left = dfs(preleft);
    		right = dfs(preright);
    		root.left = null;
    		root.right = preleft;
    		left.right = preright;
    		return right;
    	}
    }
}