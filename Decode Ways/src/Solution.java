
public class Solution {
	
    public int numDecodings(String s) {
    	int l = s.length();
    	if (l == 0)	return 0;
    	int[] counts = new int[l+1];
    	
    	counts[l] = 1;
    	if (s.charAt(l-1) != '0')	counts[l-1] = 1;
    	
    	for (int i = l-2; i >=0; i--) {
    		if (s.charAt(i) == '0')	continue;
    		counts[i] = Integer.parseInt(s.substring(i, i+2)) <=26? counts[i+1]+counts[i+2] : counts[i+1];
    	}
    	
    	return counts[0];
    }
}
