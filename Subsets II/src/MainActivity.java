import java.util.List;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2, 3};
		Solution s = new Solution();
		List<List<Integer>> res = s.subsetsWithDup(nums);
		System.out.println(res);
	}

}
