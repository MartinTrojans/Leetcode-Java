package code_test;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for(int i = 0; i< len; i++){
        	if (nums[i] == val){
        		swap(nums, len, i);
        		len--;
        		i--;
        	}
        }
        
        return len;
    }
    public void swap(int[] nums, int len, int index){
    	int temp = nums[index];
    	nums[index] = nums[len - 1];
    	nums[len - 1] = temp;
    }
}
