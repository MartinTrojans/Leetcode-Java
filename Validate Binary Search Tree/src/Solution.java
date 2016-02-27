
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long a, long b) {
    	if (root == null)	return true;
        if (root.val <= a || root.val >= b)	return false;        
        return helper(root.left, a, root.val<b? root.val:b) && helper(root.right, root.val>a? root.val:a, b);
    }
}