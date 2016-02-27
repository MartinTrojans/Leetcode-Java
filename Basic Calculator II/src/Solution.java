import java.util.Stack;

public class Solution {
    public int calculate(String s) {
    	Stack<Long> stack = new Stack<Long>();
    	
        int i = 0;
        char op = '+';
        long num = 0;
        
        while (i < s.length()) {
        	if (Character.isDigit(s.charAt(i))) {
        		while (i < s.length() && Character.isDigit(s.charAt(i)))
        			num = num * 10 + s.charAt(i++) - '0';
        	}
        	else if (s.charAt(i) == ' ')
        		i++;
        	else {
        		if (op == '+')
        			stack.push(num);
        		else if (op == '-')
        			stack.push(-num);
        		else if (op == '*')
        			stack.push(stack.pop() * num);
        		else if (op == '/')
        			stack.push(stack.pop() / num);
        		num = 0;
        		op = s.charAt(i++);
        	}
        }
        
        if (op == '+')
			stack.push(num);
		else if (op == '-')
			stack.push(-num);
		else if (op == '*')
			stack.push(stack.pop() * num);
		else if (op == '/')
			stack.push(stack.pop() / num);
        
        int res = 0;
        for (Long n: stack)
        	res += n;
        
        return res;
    }
}