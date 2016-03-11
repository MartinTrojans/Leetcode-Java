
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = {2,3,3,2,2,2,1,1};
		s.wiggleSort(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
