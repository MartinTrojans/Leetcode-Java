
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = inorder.length;
        if (l == 0)
        	return null;
        TreeNode root = new TreeNode(postorder[l-1]);
        TreeNode left = null;
        TreeNode right = null;
        int index = 0;
        for (; index < l; index++){
        	if (inorder[index] == postorder[l-1])
        		break;
        }
        
        
        if (index > 0){
        	int[] leftinorder = new int[index];
            int[] leftpostorder = new int[index];
        	System.arraycopy(inorder, 0, leftinorder, 0, index);
        	System.arraycopy(postorder, 0, leftpostorder, 0, index);
        	left = buildTree(leftinorder, leftpostorder);
        }
        if (index < l-1){
        	int[] rightinorder = new int[l-index-1];
            int[] rightpostorder = new int[l-index-1];
            System.arraycopy(inorder, index+1, rightinorder, 0, l-index-1);
            System.arraycopy(postorder, index, rightpostorder, 0, l-index-1);
            right = buildTree(rightinorder, rightpostorder);
        }
        root.left = left;
        root.right = right;
        	
        return root;
    }
}
