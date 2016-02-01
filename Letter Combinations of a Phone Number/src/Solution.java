import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
	static private Map<Character, char[]> hmap = new HashMap<Character, char[]>();
	
	private Character two = new Character('2');
	private char[] twoC = {'a', 'b', 'c'};
	private Character three = new Character('3');
	private char[] threeC = {'d', 'e', 'f'};
	private Character four = new Character('4');
	private char[] fourC = {'g', 'h', 'i'};
	private Character five = new Character('5');
	private char[] fiveC = {'j', 'k', 'l'};
	private Character six = new Character('6');
	private char[] sixC = {'m', 'n', 'o'};
	private Character seven = new Character('7');
	private char[] sevenC = {'p', 'q', 'r', 's'};
	private Character eight = new Character('8');
	private char[] eightC = {'t', 'u', 'v'};
	private Character nine = new Character('9');
	private char[] nineC = {'w', 'x', 'y', 'z'};
	
	public Solution(){
		hmap.put(two, twoC);
        hmap.put(three, threeC);
        hmap.put(four, fourC);
        hmap.put(five, fiveC);
        hmap.put(six, sixC);
        hmap.put(seven, sevenC);
        hmap.put(eight, eightC);
        hmap.put(nine, nineC);
	}
	
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        backTracing(digits, 0, "", res);
        
        return res;
    }
    
    private void backTracing(String digits, int index, String cur, List<String> res){
    	int l = digits.length();
    	if (l == 0)
    		return;
    	if (index == l){
    		res.add(cur);
    		return;
    	}
    		
        
    	Character tmpc = new Character(digits.charAt(index));
    	if(hmap.containsKey(tmpc)){
    		for (char c :hmap.get(tmpc)){
        		backTracing(digits, index+1, cur+c, res);
        	}
    	}
        
    }
}
