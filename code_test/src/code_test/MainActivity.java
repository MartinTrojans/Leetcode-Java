package code_test;

public class MainActivity {
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 4, 9, 1, 3};
		int val = 4, len = nums.length;
		Solution s = new Solution();

		for(int i = 0; i < len; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println("length1:" + nums.length);
		len = s.removeElement(nums, val);
		for(int i = 0; i < len; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println("length2:" + len);
	}
}	
