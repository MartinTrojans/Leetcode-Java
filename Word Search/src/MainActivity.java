
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'E', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		String word = "ABCESEEEFS";
		System.out.println(s.exist(board, word));
	}

}
