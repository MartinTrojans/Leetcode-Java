
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
        	return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
        	i--;
        }
        
        if (i == -1){
        	reverse(nums, 0, nums.length-1);
        	return;
        }
        
        int j = i+1;
        while (j < nums.length && nums[j] > nums[i]){
        	j++;
        }
        j--;
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1);
        
        return;
    }
    private void swap(int[] nums, int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j){
    	while (i < j){
    		swap(nums, i++, j--);
    	}
    }
}