
public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String[] res = new String[1 << n];
        if (n == 0) return res;
        res[0] = "0";
        res[1] = "1";
        
        for (int i = 1; i < n; i++) {
        	for (int j = 0; j < (1 << i); j++) {
        		res[(1 << i+1) - 1 - j] = "1" + res[j];
        		res[j] = "0" + res[j];
        	}
        }
        
        return res;
    }
    
    public String[] getGrayRecursively(int n) {
    	String[] res = new String[1 << n];
    	if (n == 1) {
    		res[0] = "0";
    		res[1] = "1";
    		return res;
    	}
    	
    	String[] last = getGrayRecursively(n-1);
    	
    	for (int i = 0; i < last.length; i++) {
    		res[i] = "0" + last[i];
    		res[res.length - 1 - i] = "1" + last[i];
    	}
    	
    	return res;
    }
}