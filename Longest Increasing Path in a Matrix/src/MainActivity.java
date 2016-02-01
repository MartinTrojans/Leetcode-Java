
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Solution s = new Solution();
			int[][] matrix = {{7,7,5},{2,4,6},{8,2,0}};
			int num = s.longestIncreasingPath(matrix);
			System.out.println(num);
	}

}
