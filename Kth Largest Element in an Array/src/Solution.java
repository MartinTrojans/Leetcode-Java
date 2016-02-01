import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	
	public int findKthLargest1(int[] nums, int k) {
		int len = nums.length;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(len, new HeapComparator());
		for (int i = 0; i < len; i++){
        	heap.add(nums[i]);
        }
		for (int i = 0; i < k-1; i++){
			heap.poll();
		}
		return heap.peek();
	}
	
	class HeapComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int i1 = (int)o1;
			int i2 = (int)o2;
			if (i1 > i2)
				return -1;
			else if (i1 == i2)
				return 0;
			else
				return 1;
		}
		
	}
	
    public int findKthLargest2(int[] nums, int k) {
    	int len = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        for (int i = 0; i < k; i++){
        	heap.add(nums[i]);
        }
        for (int i = k; i < len; i++){
        	if (nums[i] > heap.peek()){
        		heap.poll();
        		heap.add(nums[i]);
        	}
        }
        return heap.peek();
    }
    
	public int findKthLargest3(int[] nums, int k) {
		int len = nums.length;
		return quickselect(nums, 0, len-1, k);
	}
	
	private int quickselect(int[] nums, int left, int right, int k){
		int pivotIndex = partition(nums, left, right, left);
		if (pivotIndex == k-1){
			return nums[pivotIndex];
		}
		else if(pivotIndex < k){
			return quickselect(nums, pivotIndex+1, right, k);
		}
		else{
			return quickselect(nums, left, pivotIndex-1, k);
		}
	}
	
	private int partition(int[] nums, int left, int right, int index){
		int pivotvalue = nums[index];
		int storeindex = left;
		nums[index] = nums[right];
		for (int i = left; i < right; i++){
			if (nums[i] > pivotvalue){
				int temp = nums[i];
				nums[i] = nums[storeindex];
				nums[storeindex++] = temp;
			}
		}
		nums[right] = nums[storeindex];
		nums[storeindex] = pivotvalue;
		return storeindex;
	}
	
	public void quicksort(int[] nums, int left, int right){
		if (left >= right)
			return;
		int pivotIndex = partition(nums, left, right, left);
		quicksort(nums, left, pivotIndex-1);
		quicksort(nums, pivotIndex+1, right);
	}
}
