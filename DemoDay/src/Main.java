import java.util.Scanner;

public class Main {
	
	static int m = 0;
	static int n = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		String[] num = in.nextLine().trim().split(" ");
		m = Integer.parseInt(num[0]);
		n = Integer.parseInt(num[1]);
		String[] maze = new String[m];
		
		for (int i = 0; i < m; i++) {
			maze[i] = in.nextLine().trim();
		}
		
		System.out.println(dp(maze, 0, 0, 0));
		
		
		in.close();
	}
	
	private static int dp(String[] maze, int i, int j, int d) {
		if (i == m-1 && j == n-1) return 0;
		
		int inc = maze[i].charAt(j) == 'b' ? 1:0;
		
		if (j+1 == n)	return dp(maze, i+1, j, 0)  + inc;
		if (i+1 == m)	return dp(maze, i, j+1, 1) + inc;
		
		if (d == 0 && j+1 < n && maze[i].charAt(j+1) == '.')	return Math.min(dp(maze, i, j+1, 0) + inc, dp(maze, i+1, j, 1) + inc + 1);
		if (d == 1 && i+1 < m && maze[i+1].charAt(j) == '.')	return Math.min(dp(maze, i+1, j, 1) + inc, dp(maze, i, j+1, 0) + inc + 1);
		
		return Math.min(dp(maze, i+1, j, 1) + inc, dp(maze, i, j+1, 0) + inc);
	}

}
