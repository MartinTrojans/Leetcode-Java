import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int res = 0;
		
		while (in.hasNext()) {
			int m = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			
			int[][] mushrooms = new int[m][n];
			
			while ( k > 0 ) {
				int x = in.nextInt();
				int y = in.nextInt();
				mushrooms[x][y]++;
				k--;
			}
			
			int max = -1;
			int[] pos = new int[2];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int count = 0;
					for (int p = -1; p < 2; p++){
						for (int q = -1; q < 2; q++) {
							if (i+p >=0 && i+p < m && j+q>=0 && j+q<n && mushrooms[i+p][j+q] > 0)
								count++;
						}
					}
					if (count > max) {
						max = count;
						pos[0] = i;
						pos[1] = j;
					}
						
				}
			}
			for (int p = -1; p < 2; p++){
				for (int q = -1; q < 2; q++) {
					if (pos[0]+p >=0 && pos[0]+p < m && pos[1]+q>=0 && pos[1]+q<n && mushrooms[pos[0]+p][pos[1]+q] > 0)
						mushrooms[pos[0]+p][pos[1]+q]--;
				}
			}
			res += max;
			
			max = -1;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int count = 0;
					for (int p = -1; p < 2; p++){
						for (int q = -1; q < 2; q++) {
							if (i+p >=0 && i+p < m && j+q>=0 && j+q<n && mushrooms[i+p][j+q] > 0)
								count++;
						}
					}
					if (count > max) 
						max = count;
						
				}
			}
			res += max;
			
			System.out.println(res);
			
		}
		
	}
	
}
