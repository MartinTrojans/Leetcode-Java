import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public int nthUglyNumber1(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int[] index = new int[3];
        int[] list = new int[3];
        int[] primes = {2, 3, 5};
        list[0] = 1;
        list[1] = 1;
        list[2] = 1;
        
        for (int i = 1; i < n; i++){
        	for (int j = 0; j < 3; j++){
        		list[j] = res.get(index[j]) * primes[j];
        	}
        	res.add(Math.min(Math.min(list[0], list[1]), list[2]));
        	for (int j = 0; j < 3; j++){
        		if (list[j] == res.get(res.size()-1))
        			index[j]++;
        	}
        }
        
        return res.get(n-1);
    }
    
    public int nthUglyNumber2(int n){
    	List<Integer> res = new ArrayList<Integer>();
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    	heap.add(1);
    	int[] primes = {2, 3, 5};
    	while (res.size() != n) {
    		int num = heap.poll();
    		if (res.size() == 0 || num != res.get(res.size()-1))
    			res.add(num);
    		for ( int j = 0; j < 3; j++){
    			heap.add(num * primes[j]);
    		}
    	}
    	
    	return res.get(n-1);
    }
    
}