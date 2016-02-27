import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1){
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}
        List<Integer> leaves = new ArrayList<Integer>();
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>(n);
        for (int i = 0; i < n; i++)
        	adj.add(new HashSet<Integer>());
        for (int[] edge: edges){
        	adj.get(edge[0]).add(edge[1]);
        	adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++){
        	if (adj.get(i).size() == 1)
        		leaves.add(i);
        }
        
        while (n > 2){
        	n -= leaves.size();
        	List<Integer> newLeaves = new ArrayList<Integer>();
        	for (int i: leaves){
        		int j = adj.get(i).iterator().next();
        		adj.get(j).remove(i);
        		if (adj.get(j).size() == 1)
        			newLeaves.add(j);
        	}
        	leaves = newLeaves;
        }
        
        return leaves;
    }
	
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        int res1 = -1;
        int res2 = -1;
        
        for (int i = 0; i < n; i++){
        	int temp = bfs(n, i, edges);
        	if (temp < min){
        		min = temp;
        		res1 = i;
        	}
        	else if (temp == min){
        		res2 = i;
        	}
        }
        
        if (res1 != -1)
        	res.add(res1);
        if (res2 != -1)
        	res.add(res2);
        
        return res;
    }
    
    private int bfs(int n, int i, int[][] edges){
    	int height = 0;
    	boolean[] used = new boolean[edges.length];
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(i);
    	
    	while (!q.isEmpty()){
    		int num = q.size();
    		while (num > 0){
    			int temp = q.poll();
    			for (int j = 0; j < edges.length; j++){
    				if (edges[j][0] == temp || edges[j][1] == temp){
	    				if (used[j] == false){
	    					if (edges[j][0] == temp)
	    						q.add(edges[j][1]);
	    					else
	    						q.add(edges[j][0]);
	    					used[j] = true;
	    				}
    				}
    			}
    			num--;
    		}
    		height++;
    	}
    	
    	return height;
    }
}