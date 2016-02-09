import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		int count = strs.length;
    	List<List<String>> res = new ArrayList<List<String>>();
    	if (count == 0)
    		return res;
    	HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
    	
    	for (String str: strs){
    		char[] ca = str.toCharArray();
    		Arrays.sort(ca);
    		String temp = new String(ca);
    		if (hash.containsKey(temp)){
    			hash.get(temp).add(str);
    		}else{
    			List<String> tempres = new ArrayList<String>();
    			tempres.add(str);
    			hash.put(temp, tempres);
    		}
    	}
    	
    	for (List<String> l: hash.values()){
    		Collections.sort(l);
    		res.add(l);
    	}
    	
    	return res;
	}
	
	
    public List<List<String>> groupAnagrams2(String[] strs) {
        int count = strs.length;
    	List<List<String>> res = new ArrayList<List<String>>();
    	if (count == 0)
    		return res;
    	boolean[] used = new boolean[count];
    	
        for ( int i = 0; i < count; i++ ) {
        	if (used[i] == false){
        		List<String> tempres = new ArrayList<String>();
        		tempres.add(strs[i]);
        		used[i] = true;
        		for ( int j = i+1; j < count; j++){
        			if (used[j] == false){
        				if (check1(strs[i], strs[j])){
        					tempres.add(strs[j]);
        					used[j] = true;
        				}
        			}
        		}
        		res.add(tempres);
        	}
        }
        
        return res;
    }
    
    private boolean check1(String str1, String str2){
    	if (str1.length() != str2.length())
    		return false;
    	char[] res1 = str1.toLowerCase().toCharArray();
    	char[] res2 = str2.toLowerCase().toCharArray();
    	Arrays.sort(res1);
    	Arrays.sort(res2);
    	if (Arrays.equals(res1, res2))
    		return true;
    	else
    		return false;
    }
    
    private boolean check2(String str1, String str2){
    	if (str1.length() != str2.length())
    		return false;
    	HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
    	
    	for (int i = 0; i < str1.length(); i++){
    		char c1 = str1.charAt(i);
    		int n1 = 0;
    		if (hash.containsKey(c1)){
    			n1 = hash.get(c1);
    		}
    		hash.put(c1, ++n1);
    		char c2 = str2.charAt(i);
    		int n2 = 0;
    		if (hash.containsKey(c2)){
    			n2 = hash.get(c2);
    		}
    		hash.put(c2, --n2);
    	}
    	for (Integer i: hash.values()){
    		if (i != 0)
    			return false;
    	}
    	return true;
    }
}