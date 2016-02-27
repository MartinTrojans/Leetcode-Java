
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null)	return null;
        ListNode p = head;
        int count = 1;
        while (p.next != null) {
        	p = p.next;
        	count++;
        }
        if (k == count)	return head;
        p.next = head;
        p = head;
        for (int i = 1; i < count - k; i++) {
        	p = p.next;
        }
        ListNode nhead = p.next;
        p.next = null;
        
        return nhead;
    }
}