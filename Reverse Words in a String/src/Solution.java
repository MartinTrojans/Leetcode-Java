
public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        
        for (int i = strs.length-1; i >= 0; i--) 
        	res.append(strs[i] + " ");
        
        return res.toString().trim();
    }
}