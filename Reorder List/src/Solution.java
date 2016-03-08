
public class Solution {
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null)	return;
		ListNode slow = head, fast = head.next, preMiddle, preCurrent, current, p, q;
        
        //find the middle
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        //reverse the second half
        preMiddle = slow;
        preCurrent = slow.next;
        while (preCurrent.next != null) {
        	current = preCurrent.next;
        	preCurrent.next = current.next;
        	current.next = preMiddle.next;
        	preMiddle.next = current;
        }
        
        //connect two parts
        p = head;
        q = preMiddle.next;
        while (p != preMiddle) {
        	preMiddle.next = q.next;
        	q.next = p.next;
        	p.next = q;
        	p = q.next;
        	q = preMiddle.next;
        }
        
    }
}