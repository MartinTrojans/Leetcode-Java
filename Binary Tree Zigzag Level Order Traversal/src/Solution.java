import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	int flag = 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> tempstack = new Stack<TreeNode>();
        if (root == null)
        	return res;
        stack.add(root);
        while (!stack.isEmpty() || !tempstack.isEmpty()){
        	tempstack = new Stack<TreeNode>();
        	List<Integer> tempres = new ArrayList<Integer>();
        	while (!stack.isEmpty()){
            	TreeNode node = stack.pop();
            	tempres.add(node.val);
            	if (flag == 0){
            		if (node.left != null){
                		tempstack.add(node.left);
                	}
                	if (node.right != null){
                		tempstack.add(node.right);
                	}
            	}
            	else{
            		if (node.right != null){
                		tempstack.add(node.right);
                	}
            		if (node.left != null){
                		tempstack.add(node.left);
                	}
            	}
            	
            }
        	res.add(tempres);
        	stack.addAll(tempstack);
        	flag ^= 1;
        }
        
        return res;
    }
}