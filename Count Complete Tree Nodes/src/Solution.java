
public class Solution {
    public int countNodes(TreeNode root) {
    	int h = height(root);
        if (h == 0)
        	return 0;
        if (h == height(root.right)+1){
        	return (1 << (h-1)) + countNodes(root.right);
        } else {
        	return (1 << (h-2)) + countNodes(root.left);
        }
    }
    
    private int height(TreeNode root) {
    	return root == null? 0 : 1 + height(root.left);
    }
}