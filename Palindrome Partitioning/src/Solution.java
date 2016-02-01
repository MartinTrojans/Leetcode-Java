import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<String>> partition1(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	int len = s.length();
    	if (palindrome(s)){
			List<String> tempres = new ArrayList<String>();
			tempres.add(s);
			res.add(tempres);
    	}
    	for (int i = 1; i < len; i++){
    		if (palindrome(s.substring(0, i))){
    			for (List<String> list: partition(s.substring(i))){
    				list.add(0, s.substring(0, i));
    				res.add(list);
    			}
    		}
    	}
    	return res;
    }
    
    private boolean palindrome(String s){
    	int len = s.length();
    	int left = 0;
    	int right = len - 1;
    	while (left < right){
    		if (s.charAt(left) != s.charAt(right)){
    			return false;
    		}
    		left++;
    		right--;
    	}
    	return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<> ();
        if(s == null || s.length() == 0) {
            return result;
        }
        helper(result, new ArrayList<String> (), s, 0, getPalindromes(s));
        return result;
    }

    private void helper(List<List<String>> result, List<String> section, String s, int index, boolean[][] isPalindromes) {
        if(index  == s.length()) {
            result.add(new ArrayList<> (section));
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindromes[index][i]) {
                String temp = s.substring(index, i + 1);
                section.add(temp);
                helper(result, section, s, i + 1, isPalindromes);
                section.remove(section.size() - 1);
            }
        }
    }

    private boolean[][] getPalindromes(String s) {
        int len = s.length();
        boolean[][] result = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            result[i][i] = true;
        }
        for(int i = 1; i < len; i++) {
            result[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        for(int i = 2; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                result[j][j + i] = result[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
            }
        }
        return result;
    }
}