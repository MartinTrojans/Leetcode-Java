
public class Solution {
	static int l;
	static int[] dpr;
	public int rob(int[] nums) {
		l = nums.length;
		
		if(l == 0){
			return 0;
		}
		if(l == 1){
			return nums[0];
		}
		
		dpr = new int[l-1];
		for (int i = 1; i < l-1; i++){
			dpr[i] = -1;
		}
		dpr[0] = nums[0];
		int res1 = dp(nums, l-2);
		int [] newnums = new int[l-1];
		System.arraycopy(nums, 1, newnums, 0, l-1);
		
		dpr = new int[l-1];
		for (int i = 1; i < l-1; i++){
			dpr[i] = -1;
		}
		dpr[0] = nums[1];
		int res2 = dp(newnums, l-2);
		
		if(res1 > res2)
			return res1;
		else
			return res2;
    }
	
	public int dp(int[] nums, int i){
		if (i == 0){
			return nums[0];
		}
		int res1;
		if (dpr[i-1] < 0){
			res1 = dp(nums, i-1);
		}
		else{
			res1 = dpr[i-1];
		}
		int res2;
		if (i == 1){
			res2 = nums[i];
		}
		else if (dpr[i-2] < 0){
			res2 = dp(nums, i-2) + nums[i];
		}
		else{
			res2 = dpr[i-2] + nums[i];
		}
		if(res1 > res2){
			dpr[i] = res1;
			return res1;
		}
		else{
			dpr[i] = res2;
			return res2;
		}
	}
}
