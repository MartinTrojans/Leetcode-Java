import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			char[][] matrix = new char[3][3];
			matrix[0] = in.nextLine().trim().toCharArray();
			matrix[1] = in.nextLine().trim().toCharArray();
			matrix[2] = in.nextLine().trim().toCharArray();
			
			int count1 = 0, count2 = 0;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (matrix[i][j] == 'X') {
						count1++;
					} else if (matrix[i][j] == '0') {
						count2++;
					}
				}
			}
			if (!(count1 - count2 >= 0 && count1 - count2 <= 1)) {
				System.out.println("x");
				continue;
			}
			
			boolean w1 = false, w2 = false;
			
			if (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') {
				w1 = true;
			}
			if (matrix[0][0] == '0' && matrix[1][1] == '0' && matrix[2][2] == '0') {
				w2 = true;
			}
			if (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X') {
				w1 = true;
			}
			if (matrix[0][2] == '0' && matrix[1][1] == '0' && matrix[2][0] == '0') {
				w2 = true;
			}
			
			for (int i = 0; i < 3; i++) {
				if (matrix[i][0] == 'X' && matrix[i][1] == 'X' && matrix[i][2] == 'X') {
					w1 = true;
				}
				if (matrix[0][i] == 'X' && matrix[1][i] == 'X' && matrix[2][i] == 'X') {
					w1 = true;
				}
				if (matrix[i][0] == '0' && matrix[i][1] == '0' && matrix[i][2] == '0') {
					w2 = true;
				}
				if (matrix[0][i] == '0' && matrix[1][i] == '0' && matrix[2][i] == '0') {
					w2 = true;
				}
			}
			
			if (w1 && w2) {
				System.out.println("x");
				continue;
			} else if (w1) {
				System.out.println("1 won");
				continue;
			} else if (w2) {
				System.out.println("2 won");
				continue;
			}
			
			if (count1 + count2 == 9) {
				System.out.println("draw");
				continue;
			}
			if (count1 - count2 == 0) {
				System.out.println("1");
				continue;
			}
			if (count1 - count2 == 1) {
				System.out.println("2");
				continue;
			}
			System.out.println("x");
		}
		in.close();
	}

}
