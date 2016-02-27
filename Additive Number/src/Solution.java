
public class Solution {
	
    public boolean isAdditiveNumber(String num) {
     
    	int len = num.length();
    	
    	long num1 = 0;
    	long num2 = 0;
    	//find the first two elements first
    	for (int i = 1; 2*i+1 <= len; i++){
    		for (int j = 1; Math.max(i, j) <= len-i-j; j++){
    			if (num.charAt(0) == '0' && i > 1)	return false;//if first char is 0, then it only can be 0
    			num1 = Long.parseLong(num.substring(0, i));
    			if (num.charAt(i) == '0' && j > 1)	break;//if second element start with 0, then it only can be 0
        		num2 = Long.parseLong(num.substring(i, i+j));
        		if (isValid(num1, num2, i+j, num))//check the rest recursively
        			return true;
    		}
    	}
    	
    	return false;
    }
    
    private boolean isValid(long i, long j, int start, String num){
    	if (start == num.length())	return true;//no rest chars left, success
    	if (num.charAt(start) == '0')	return false;
    	long sum = 0;
    	for (int idx = start+1; idx <= num.length(); idx++){
    		sum = Long.parseLong(num.substring(start, idx));
    		if (sum - i > j)
    			return false;
    		if (sum - i == j)
    			return isValid(j, sum, idx, num);
    	}
    	return false;
    }
    
}