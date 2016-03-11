import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> maxHeap = new PriorityQueue<String>(new NumComparator());
        StringBuilder res = new StringBuilder();
        
        for (int num: nums)
        	maxHeap.add(Integer.toString(num));
        
        while (!maxHeap.isEmpty())
        	res.append(maxHeap.poll());
        
        return res.toString().charAt(0) == '0'? "0" : res.toString();
    }
    
    public class NumComparator implements Comparator<String> {
    	
    	@Override
    	public int compare(String s1, String s2) {
			String str1 = s1 + s2;
			String str2 = s2 + s1;
		
			return str2.compareTo(str1);
    	}
    }
}