
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] preorder = {1, 2, 3};
		int[] inorder = {2, 3, 1};
		s.buildTree(preorder, inorder);
	}

}
