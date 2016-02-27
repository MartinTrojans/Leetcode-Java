
public class Solution {
	int max = 1;
    String res = "";
    public String longestPalindrome(String s) {
        if (s.length() < 2)
        	return s;
        for (int i = 0; i < s.length() - max/2; i++){
        	
        	if (i+1<s.length() && s.charAt(i) == s.charAt(i+1)){
        		check(s, i-1, i+2, 2);
        	}
        	
        	check(s, i-1, i+1, 1);
        }
        
        return res;
    }
    
    private void check(String s, int i, int j, int len){
    	int count = len;
		while (i >= 0 && j < s.length()){
			if (s.charAt(i) == s.charAt(j))
				count += 2;
			else
				break;
			i--;
			j++;
		}
		if (count > max){
			res = s.substring(i+1, j);
			max = count;
		}
    	
    }
}