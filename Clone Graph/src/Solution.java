import java.util.HashMap;

public class Solution {
	HashMap<Integer, UndirectedGraphNode> exploredSet = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node){
    	if (node == null) return null;
    	UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

    	exploredSet.put(node.label, newNode);
    	
    	for (UndirectedGraphNode n: node.neighbors) {
    		if (exploredSet.containsKey(n.label)) {
    			newNode.neighbors.add(exploredSet.get(n.label));
    		} else {
    			newNode.neighbors.add(clone(n));
    		}
    	}
    	
    	return newNode;
    }
}