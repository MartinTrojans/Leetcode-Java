import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> findRepeatedDnaSequences1(String s) {
        HashSet<String> set = new HashSet<String>();
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i+10 <= s.length(); i ++) {
        	String temp = s.substring(i, i+10);
        	if (!set.contains(temp)) {
        		set.add(temp);
        	}
        	else {
        		if (!res.contains(temp))
        			res.add(temp);
        	}
        }
        
        return res;
    }
    
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> second = new HashSet<Integer>();
        List<String> res = new ArrayList<String>();
        
        if (s.length() < 10)	return res;
        
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        
        int v = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	v <<= 2;
        	v |= map.get(s.charAt(i));
        	v &= 0xfffff;
        	if (i < 9)	continue;
        	if (!set.add(v) && second.add(v)) {
        		res.add(s.substring(i-9, i+1));
        	}
        }
        
        return res;
    }
}