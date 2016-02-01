
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] board = {{1,0}, {0,1}};
		s.gameOfLife(board);
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

}
