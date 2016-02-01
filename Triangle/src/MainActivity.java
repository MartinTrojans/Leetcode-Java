import java.util.List;
import java.util.ArrayList;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> first = new ArrayList<Integer>();
		first.add(2);
		List<Integer> second = new ArrayList<Integer>();
		second.add(3);
		second.add(4);
		List<Integer> third = new ArrayList<Integer>();
		third.add(6);
		third.add(5);
		third.add(7);
		List<Integer> forth = new ArrayList<Integer>();
		forth.add(4);
		forth.add(1);
		forth.add(8);
		forth.add(3);
		triangle.add(first);
		triangle.add(second);
		triangle.add(third);
		triangle.add(forth);
		
		System.out.println(s.minimumTotal(triangle));
	}

}
