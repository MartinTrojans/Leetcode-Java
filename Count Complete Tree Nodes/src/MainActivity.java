
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		//root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		System.out.println(s.countNodes(root));
	}

}
