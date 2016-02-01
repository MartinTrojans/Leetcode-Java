
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = {-1, 2, 0};
		System.out.println(s.findKthLargest3(nums, 1));
		s.quicksort(nums, 0, 2);
		for (int i = 0; i < 3; i++){
			System.out.println(nums[i]);
		}
	}

}
