import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/");
        
        for (String p: paths) {
        	p = p.trim();
        	if (p.equals("") || p.equals("."))	continue;
        	if (p.equals(".."))	{
        		if (!stack.isEmpty()) {
        			stack.pop();
        		}
        		continue;
        	}
        	stack.push(p);
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) 
        	res.insert(0, "/".concat(stack.pop()));
        	
        
        return res.length() == 0? "/":res.toString();
    }
}