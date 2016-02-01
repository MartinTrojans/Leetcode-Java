
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
        	return null;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode s = prehead;
        ListNode l = prehead;
        while(s != null && l != null){
        	while(s.next != null){
        		if (s.next.val >= x)
        			break;
        		s = s.next;
        	}
        	l = s.next;
        	if (l == null)
        		break;
        	while(l.next != null){
        		if (l.next.val < x)
        			break;
        		l = l.next;
        	}
        	if (l.next == null)
        		break;
        	ListNode tmp = l.next;
        	l.next = l.next.next;
        	tmp.next = s.next;
        	s.next = tmp;
        }
        
        return prehead.next;
    }
	
}

/*

public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
            return head;
        
        ListNode small = new ListNode(-1);
        ListNode newsmallhead = small;
        ListNode big = new ListNode(-1);
        ListNode newbighead = big;
        
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        
        small.next = newbighead.next;
        
        return newsmallhead.next;
    }
*/