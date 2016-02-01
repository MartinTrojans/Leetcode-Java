import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int second = 0, third = 0, nexti = 0, nextj = 0;
        for(int i=0, L=nums.length; i<L-3; i++) {
            if(nums[i]<<2 > target) return list; // return immediately
            for(int j=L-1; j>i+2; j--) {
                if(nums[j]<<2 < target) break; // break immediately
                int rem = target-nums[i]-nums[j];
                int lo = i+1, hi=j-1;
                while(lo<hi) {
                    int sum = nums[lo] + nums[hi];
                    if(sum>rem) --hi;
                    else if(sum<rem) ++lo;
                    else {
                        list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
                        while(++lo<=hi && nums[lo-1]==nums[lo]) continue; // avoid duplicate results
                        while(--hi>=lo && nums[hi]==nums[hi+1]) continue; // avoid duplicate results
                    }
                }
                while(j>=1 && nums[j]==nums[j-1]) --j; // skip inner loop
            }
            while(i<L-1 && nums[i]==nums[i+1]) ++i; // skip outer loop
        }
        return list;
    }

	public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> tres = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        
        
        for (int i = 0; i < len-3; i++){
        	for (int j = i+1; j < len-2; j++){
        		for (int k = j+1; k < len-1; k++){
        			int l = len-1;
        			while (k < l){
        				int sum = nums[i] + nums[j] + nums[k] + nums[l];
        				if (sum == target){
        					List<Integer> tempres = new ArrayList<Integer>();
        					tempres.add(nums[i]);
        					tempres.add(nums[j]);
        					tempres.add(nums[k]);
        					tempres.add(nums[l]);
        					tres.add(tempres);
        					k++;
        					l--;
        				}
        				else if (sum > target){
        					l--;
        				}
        				else{
        					k++;
        				}
        				while (k < l && nums[k+1] == nums[k]){
        					k++;
        				}
        				while (k < l && nums[l-1] == nums[l]){
        					l--;
        				}
        			}
        		}
        	}
        }
        
        res.addAll(tres);
        return res;
    }
    
    public List<List<Integer>> fourSum2(int[] nums, int target){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	int len = nums.length;
    	if (len < 4)
    		return res;
    	Pair[] pairSum = new Pair[len*(len-1)/2];
    	Set<List<Integer>> tres = new HashSet<List<Integer>>();
    	
    	int count = 0;
    	for (int i = 0; i < len-1; i++){
    		for (int j = i+1; j < len; j++){
    			Pair ele = new Pair(nums[i], nums[j], i, j);
    			pairSum[count++] = ele;
    		}
    	}
    	Arrays.sort(pairSum, new SumComparator());
    	
    	int left = 0;
    	int right = pairSum.length - 1;
    	while (left < right){
    		int sum = pairSum[left].getSum() + pairSum[right].getSum();
    		if (sum == target){
    			int endl = left;
    			int endr = right;
    			while (pairSum[endl].getSum() == pairSum[endl+1].getSum() && endl+1 < endr){
    				endl++;
    			}
    			while (pairSum[endr].getSum() == pairSum[endr-1].getSum() && endl < endr-1){
    				endr--;
    			}
    			for (int i = left; i <= endl; i++){
    				for (int j = right; j>= endr; j--){
    					int i1 = pairSum[i].geti();
    	    			int i2 = pairSum[j].geti();
    	    			int j1 = pairSum[i].getj();
    	    			int j2 = pairSum[j].getj();
    	    			if (i1 == i2 || i1 == j2 || j1 == i2 || j1 == j2){
    	    				continue;
    	    			}
    	    			int[] temp = new int[4];
    	    			temp[0] = pairSum[i].getN1();
    	    			temp[1] = pairSum[i].getN2();
    	    			temp[2] = pairSum[j].getN1();
    	    			temp[3] = pairSum[j].getN2();
    	    			Arrays.sort(temp);
    	    			List<Integer> tempres = new ArrayList<Integer>();
    	    			tempres.add(temp[0]);
    	    			tempres.add(temp[1]);
    	    			tempres.add(temp[2]);
    	    			tempres.add(temp[3]);
    	    			tres.add(tempres);
    				}
    			}
    			left = endl+1;
    			right = endr-1;
    		}
    		else if (sum > target){
    			right--;
    		}
    		else{
    			left++;
    		}
    	}
    	
    	res.addAll(tres);
    	return res;
    }
    
    class SumComparator implements Comparator{

		@Override
		public final int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			Pair l1 = (Pair)o1;
			Pair l2 = (Pair)o2;
			if (l1.getSum() > l2.getSum())
				return 1;
			else if (l1.getSum() < l2.getSum())
				return -1;
			else
				return 0;
		}
    }
    
    class Pair{
    	int i;
    	int j;
    	int n1;
    	int n2;
    	int sum;
    	Pair(int num1, int num2, int i, int j){
    		this.n1 = num1;
    		this.n2 = num2;
    		this.sum = num1 + num2;
    		this.i = i;
    		this.j = j;
    	}
    	public int getSum(){
    		return this.sum;
    	}
    	public int getN1(){
    		return this.n1;
    	}
    	public int getN2(){
    		return this.n2;
    	}
    	public int geti(){
    		return this.i;
    	}
    	public int getj(){
    		return this.j;
    	}
    }
}