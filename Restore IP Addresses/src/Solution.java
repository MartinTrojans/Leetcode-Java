import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        
        if (s.length() < 4)
        	return res;
        if (s.length() > 12)
        	return res;
        
        backtracing(s, 0, new ArrayList<String>(), res);
        
        return res;
    }
    
    public void backtracing(String s, int start, List<String> tempres, List<String> res){
    	if (start == s.length()){
    		if (tempres.size() == 4){
    			String tempstr = "";
    			tempstr = tempres.get(0) + "." + tempres.get(1) + "." + tempres.get(2) + "." + tempres.get(3);
    			res.add(tempstr);
    		}
    		else{
    			return;
    		}
    	}
    	
    	for (int i = start+1; i <= s.length(); i++){
    		if (s.charAt(start) == '0' && i != start+1)
    			continue;
    		if (i - start > 3)
    			break;
    		int num = Integer.parseInt(s.substring(start, i));
    		if (num > 255)
    			break;
    		else{
    			tempres.add(s.substring(start, i));
    			backtracing(s, i, tempres, res);
    			tempres.remove(tempres.size() - 1);
    		}
    	}
    }
}