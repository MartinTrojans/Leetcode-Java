import java.util.Queue;
import java.util.LinkedList;

public class Codec {

	//normal method
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	String res = "";
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while (!q.isEmpty()){
    			TreeNode n = q.poll();
        		if (n == null){
        			res += "null,";
        		}
        		else{
        			res += n.val + ",";
        			q.add(n.left);
        			q.add(n.right);
        		}
    	}
    	
		return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.length() == 0)
    		return null;
    	String[] strs = data.split(",");
    	int len = strs.length;
    	TreeNode[] nodes = new TreeNode[len];
    	int[] nnums = new int[len];
    	
    	for (int i = 0; i < len; i++){
    		if (i > 0){
    			nnums[i] = nnums[i-1];
    		}
    		if (strs[i].equals("null")){
    			nodes[i] = null;
    			nnums[i]++;
    		}
    		else{
    			nodes[i] = new TreeNode(Integer.parseInt(strs[i]));
    		}
    	}
    	
    	for (int i = 0; i < len; i++){
    		if (nodes[i] == null){
    			continue;
    		}
    		else{
				nodes[i].left = nodes[(i-nnums[i])*2 + 1];
				nodes[i].right = nodes[(i-nnums[i])*2 + 2];
    		}
    	}
    	
    	return nodes[0];
    }
    
    //record the index of the left child and right child 
    public String serialize1(TreeNode root) {
    	String res = "";
    	
    	
		return res;
    }
    
    
    //split the left child and right child
}