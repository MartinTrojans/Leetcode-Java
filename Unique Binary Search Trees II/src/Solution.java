import java.util.List;
import java.util.ArrayList;
/**
 * @author Martin
 *
 */

public class Solution {
	public List<TreeNode> generateTrees(int n) {
		return dp(1, n);
	}
	
	public List<TreeNode> dp(int low, int high){
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (low == high){
			TreeNode n = new TreeNode(low);
			res.add(n);
			return res;
		}
		for (int i = low; i <= high; i++){
			TreeNode n = new TreeNode(i);
			if (i == low){
				for (TreeNode p: dp(low+1, high)){
					n.right = p;
					res.add(n);
					n = new TreeNode(i);
				}
			}
			else if (i == high){
				for (TreeNode p: dp(low, high-1)){
					n.left = p;
					res.add(n);
					n = new TreeNode(i);
				}
			}
			else{
				for (TreeNode p: dp(low, i-1)){
					for (TreeNode q: dp(i+1, high)){
						n.left = p;
						n.right = q;
						res.add(n);
						n = new TreeNode(i);
					}
				}
			}
		}
		
		return res;
	}
}
