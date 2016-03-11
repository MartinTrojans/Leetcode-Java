
public class Solution {
    public void wiggleSort(int[] nums) {
    	int len = nums.length;
    	if (len < 2)	return;
    	
        quickselect(nums, (len-1)/2);
        int mid = nums[(len-1)/2];
        
        int i = 0, j = len - 1, cur = 0;
        
        while (cur <= j) {
        	if (nums[(2*cur+1)%(len|1)] > mid)
        		swap(nums, (2*(cur++)+1)%(len|1), (2*(i++)+1)%(len|1));
        	else if (nums[(2*cur+1)%(len|1)] < mid)	
        		swap(nums, (2*(cur)+1)%(len|1), (2*(j--)+1)%(len|1));
        	else	
        		cur++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    private void quickselect(int[] nums, int n) {
    	int low = 0, high = nums.length-1;
    	
    	while (true) {
    		int i = partition(nums, low, high);
    		if (i == n)	return;
    		else if (i < n) low = i + 1;
    		else	high = i - 1;
    	}
    }
    
    private int partition (int[] nums, int left, int right) {
    	int pivot = nums[left];
    	int storeIndex = left;
    	nums[left] = nums[right];
    	for (int i = left; i < right; i++) {
    		if (nums[i] <= pivot)
    			swap(nums, storeIndex++, i);
    	}
    	nums[right] = nums[storeIndex];
    	nums[storeIndex] = pivot;
    	
    	return storeIndex;
    }
}