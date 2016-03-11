import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
	List<String> res = new ArrayList<String>();
	HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket: tickets)
        	map.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
        PriorityQueue<String> q = new PriorityQueue<String>();
        visit("JFK");
        
        return res;
    }
    
    private void visit(String cur) {
    	while (map.containsKey(cur) && !map.get(cur).isEmpty())
    		visit(map.get(cur).poll());
    	res.add(0, cur);
    }
}