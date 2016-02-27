import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> alphabeta = new HashMap<Character, Integer>();
        int max = 0;
        int count = 0;
        int idx = 0;
        
        while (idx+count < s.length()) {
        	
        	if (!alphabeta.containsKey(s.charAt(idx + count))) {
        		alphabeta.put(s.charAt(idx + count), idx+count);
        		count++;
        	}
        	else {
        		idx = alphabeta.get(s.charAt(idx + count)) + 1;
        		alphabeta = new HashMap<Character, Integer>();
        		count = 0;
        	}
        	max = Math.max(max, count);
        }
        
        return max;
    }
}