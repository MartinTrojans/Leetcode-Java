
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int smallest = 0;
        if (s.length() == 0)	return "";
        for (char c: s.toCharArray())	count[c-'a']++;
        for (int i = 0; i < s.length(); i++){
        	if (s.charAt(i) < s.charAt(smallest))	smallest = i;
        	if (--count[s.charAt(i) - 'a'] == 0)	break;
        }
        return s.charAt(smallest) + removeDuplicateLetters(s.substring(smallest+1).replaceAll(s.charAt(smallest)+"", ""));
    }
}