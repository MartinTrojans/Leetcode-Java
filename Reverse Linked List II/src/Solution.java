
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (m == n)
    		return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode pre = prehead;
        ListNode cur = head;
        int idx = 1;
        
        while (idx < m) {
        	pre = cur;
        	cur = cur.next;
        	idx++;
        }
        ListNode prerever = pre;
        ListNode next = null;
        pre = cur;
    	cur = cur.next;
        while (idx < n) {
        	next = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = next;
        	idx++;
        }
        prerever.next.next = cur;
        prerever.next = pre;
        
        
        return prehead.next;
    }
}