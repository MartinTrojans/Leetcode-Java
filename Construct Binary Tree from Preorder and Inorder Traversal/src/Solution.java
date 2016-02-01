import java.util.HashMap;

public class Solution {
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = preorder.length;
        if (l == 0)
        	return null;
        for (int i = 0; i < l; i++)
        	map.put(inorder[i], i);
    	
    	return dp(preorder, inorder, 0, l-1, 0, l-1);
    }
    
    private TreeNode dp(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
    	if (preStart > preEnd || inStart > inEnd)
    		return null;
    	TreeNode root = new TreeNode(preorder[preStart]);
    	
    	int index = map.get(preorder[preStart]);
    	
    	TreeNode left = dp(preorder, inorder, preStart+1, preStart+index-inStart, inStart, index-1);
    	TreeNode right = dp(preorder, inorder,preStart+index-inStart+1, preEnd, index+1, inEnd);
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }
}

/*
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int l = preorder.length;
		if (l == 0)
			return null;
		
		
		return dp(preorder, inorder, 0, l-1, 0, l-1);
		}
		
		private TreeNode dp(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
		if (preStart > preEnd || preEnd >= preorder.length || inEnd >= preorder.length)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = inStart;
		for (; index < inEnd; index++){
			if (inorder[index] == preorder[preStart])
				break;
		}
		
		TreeNode left = dp(preorder, inorder, preStart+1, preStart+index-inStart, inStart, index-1);
		TreeNode right = dp(preorder, inorder,preStart+index-inStart+1, preEnd, index+1, inEnd);
		root.left = left;
		root.right = right;
		
		return root;
	}	
*/