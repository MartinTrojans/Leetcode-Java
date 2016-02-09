
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
        	return head;
    	ListNode dummy = new ListNode(head.val-1);
    	dummy.next = head;
    	ListNode pre = dummy;
    	ListNode p = head;
    	ListNode next = head.next;
    	while (next != null){
    		if (p.val == next.val){
    			while (next != null && p.val == next.val){
    				next = next.next;
    			}
    			pre.next = next;
    			if (next == null){
    				break;
    			} else{
    				p = next;
    				next = next.next;
    			}
    		} else{
    			pre = p;
    			p = p.next;
    			next = next.next;
    		}
    	}
        
    	return dummy.next;
    }
}