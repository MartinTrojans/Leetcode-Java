
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        int flag = 0;
    	
    	if (l1 != null){
    		num1 = l1.val;
    		l1 = l1.next;
    	}
    	if (l2 != null){
    		num2 = l2.val;
    		l2 = l2.next;
    	}
    	sum = (num1 + num2) % 10;
    	flag = (num1 + num2) / 10;
    	ListNode head = new ListNode(sum);
    	ListNode p = head;
    	
    	while (l1 != null || l2 != null){
    		num1 = 0;
    		num2 = 0;
    		if (l1 != null) {
        		num1 = l1.val;
        		l1 = l1.next;
        	}
        	if (l2 != null) {
        		num2 = l2.val;
        		l2 = l2.next;
        	}
        		
        	sum = (num1 + num2 + flag) % 10;
        	flag = (num1 + num2 + flag) / 10;
        	p.next = new ListNode(sum);
        	p = p.next;
    	}
    	
    	if (flag == 1)
    		p.next = new ListNode(1);
    	
    	return head;
    }
}