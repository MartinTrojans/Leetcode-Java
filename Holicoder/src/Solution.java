import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int num = Integer.parseInt(in.nextLine().trim());
		
		while (num > 0) {
			String[] strs = in.nextLine().trim().split(" ");
			int n = Integer.parseInt(strs[0]);
			int p = Integer.parseInt(strs[1]);
			int w = Integer.parseInt(strs[2]);
			int h = Integer.parseInt(strs[3]);
			
			String[] stra = in.nextLine().trim().split(" ");
			int sum = 0;
			//int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				sum += Integer.parseInt(stra[i]);
				//a[i] = Integer.parseInt(stra[i]);
			}
			
			for (int s = Math.min(w, h); s > 0; s--) {
				
				if (sum <= (int)Math.ceil(w/s) * (h/s) * p) {
					System.out.println(s);
					break;
				}
			}
			
			num--;
		}
		
		in.close();
	}

}
