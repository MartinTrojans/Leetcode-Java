import java.util.Set;
import java.util.HashSet;

public class Solution {
	/*
	int maxLen = Integer.MIN_VALUE;
	int minLen = Integer.MAX_VALUE;
	HashSet<Character> alphabeta = new HashSet<Character>();
    public boolean wordBreak(String s, Set<String> wordDict) {
        for (String str: wordDict){
        	if (str.length() > maxLen)
        		maxLen = str.length();
        	if (str.length() < minLen)
        		minLen = str.length();
        	for (char c: str.toCharArray()){
        		if (!alphabeta.contains(c))
        			alphabeta.add(c);
        	}
        }
        if (s.length() == 0)	return false;
        for (char c: s.toCharArray()){
        	if (!alphabeta.contains(c))
				return false;
        }
        
        return isValid(s, wordDict, 0);
    }
    
    private boolean isValid(String s, Set<String> wordDict, int i) {
    	if (i == s.length())	return true;
    	for (int len = maxLen; len >= minLen && i+len <= s.length(); len--){
    		String temp = s.substring(i, i+len);
    		if (wordDict.contains(temp)){
    			if (isValid(s, wordDict, i+len))	return true;
    		}
    	}
    	
    	return false;
    }
    */
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] valid = new boolean[s.length()+1];
		
		valid[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i-1; j >= 0; j--){
				if (valid[j] && wordDict.contains(s.substring(j, i))){
					valid[i] = true;
					break;
				}
			}
		}
		
		return valid[s.length()];
	}
}