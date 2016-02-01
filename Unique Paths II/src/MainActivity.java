
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};
		int num =s.uniquePathsWithObstacles(grid);
		System.out.println(num);
	}

}
