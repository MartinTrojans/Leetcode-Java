import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MainActivity {
	public static void main(String args[]){
		Solution s = new Solution();
		int[] nums = {0, 0, 0, 0, 0};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = s.threeSum(nums);
		System.out.println(res);
	}
}