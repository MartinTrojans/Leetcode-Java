import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int res = 0;
			int num = 0;
			int r = in.nextInt();
			int[][] coord = new int[3][2];
			int[] enemy = new int[2];
			
			while (num < 3) {
				coord[num][0] = in.nextInt();
				coord[num][1] = in.nextInt();
				num++;
			}
			enemy[0] = in.nextInt();
			enemy[1] = in.nextInt();
			
			num = 0;
			while (num < 3) {
				int xdif = coord[num][0] - enemy[0];
				int ydif = coord[num][1] - enemy[1];
				if (xdif * xdif + ydif * ydif <= r * r)
					res++;
				num++;
			}
			
			System.out.println(res + "x");
		}
		
	}

}
