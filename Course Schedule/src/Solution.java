import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Solution {
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1)
        	return true;
        ArrayList<HashSet<Integer>> edges = new ArrayList<HashSet<Integer>>(numCourses);
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++)
        	edges.add(new HashSet<Integer>());
        
        for (int[] pre: prerequisites){
        	edges.get(pre[0]).add(pre[1]);
        }
        
        for (int i = 0; i < numCourses; i++){
        	if (edges.get(i).size() != 0)
        		if (!dfs(edges, i, visited))
        			return false;
        }
        
        return true;
    }
    
    private boolean dfs(ArrayList<HashSet<Integer>> edges, int i, boolean[] visited){
    	if (visited[i] == true)
			return false;
    	visited[i] = true;
    	while (edges.get(i).size() != 0){
    		int j = edges.get(i).iterator().next();
    		
    		if (!dfs(edges, j, visited))
    			return false;
    		
    		edges.get(i).remove(j);
    	}
    	//we only check the cycle in one DFS
    	visited[i] = false;
    	return true;
    }
    
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1)
        	return true;
        ArrayList<HashSet<Integer>> edges = new ArrayList<HashSet<Integer>>(numCourses);
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        
        for (int i = 0; i < numCourses; i++)
        	edges.add(new HashSet<Integer>());
        
        for (int[] pre: prerequisites){
        	if (!edges.get(pre[0]).contains(pre[1])){
        		edges.get(pre[0]).add(pre[1]);
            	inDegree[pre[1]]++;
        	}
        }
        
        for (int i = 0; i < inDegree.length; i++)
        	if (inDegree[i] == 0)
        		q.add(i);
        
        while (!q.isEmpty()){
        	int i = q.poll();
        	count++;
        	while (edges.get(i).size() != 0){
        		int j = edges.get(i).iterator().next();
        		if (--inDegree[j] == 0)
        			q.add(j);
        		edges.get(i).remove(j);
        	}
        }
        
        return count == numCourses;
    }
}