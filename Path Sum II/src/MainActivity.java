import java.util.Iterator;
import java.util.List;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.left.right = new TreeNode(4);
		root.right.left.right.left = new TreeNode(5);
		root.right.left.right.right = new TreeNode(1);
		List<List<Integer>> res = s.pathSum(root, 22);
		for (Iterator it = res.iterator(); it.hasNext(); ){
			System.out.println(it);
			it.next();
		}
	}

}
