import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strlist = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        Stack<String> tempstack = new Stack<String>();
        
        for (String s: strlist) {
        	stack.push(s);
        }
        while (!stack.isEmpty()) {
        	while (!stack.isEmpty() && stack.peek().equals("#")){
        		tempstack.push(stack.pop());
        	}
        	if (tempstack.size() < 2)
        		break;
        	while (tempstack.size() >= 2 && !stack.isEmpty() && !stack.peek().equals("#")){
        		tempstack.pop();
        		tempstack.pop();
        		if (!stack.isEmpty() && !stack.peek().equals("#")){
        			stack.pop();
        			tempstack.push("#");
        		}
        	}
        }
        
        if (tempstack.size() == 1 && stack.isEmpty())
        	return true;
        else
        	return false;
    }
    
    public boolean isValidSerialization1(String preorder) {
        String[] p = preorder.split(",");
        int idx = 0; // stack
        for (int i = 0; i < p.length; i++) {
          if (p[i].equals("#")) {
            idx--;
          } else {
            if (idx < 0) { // check
              return false;
            }
            p[idx++] = p[i];
          }
        }
        return idx == -1; // check
      }
    
    public boolean isValidSerialization2(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}