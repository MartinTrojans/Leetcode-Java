import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int n = Integer.parseInt(in.nextLine().trim());
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			int num = 0, count = 0;
			String[] strs = in.nextLine().trim().split(" ");
			num = Integer.parseInt(strs[0]);
			for (int i = 1; i < n; i++) {
				q.add(-Integer.parseInt(strs[i]));
			}
			
			while (num <=-q.peek()) {
				int newone = q.poll() + 1;
				q.add(newone);
				num++;
				count++;
			}
			
			System.out.println(count);
		}
	}

}
