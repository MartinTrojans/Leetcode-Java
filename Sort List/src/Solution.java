
public class Solution {
	//heap sort, merge sort, quick sort
	//merge
    public ListNode sortList(ListNode head) {
    	int len = getLength(head);
    	if (len == 0)	return null;
    	ListNode nhead = mergeSort(head, len);
    	addTail(nhead, len);
    	return nhead;
    }
    
    private ListNode mergeSort(ListNode head, int n) {
    	if (n <= 1)
    		return head;
    	ListNode mid = getNode(head, n/2);
    	ListNode nhead = mergeSort(head, n/2);
    	ListNode nmid = mergeSort(mid, n - n/2);
    	return merge(nhead, nmid, n);
    }
    
    private int getLength(ListNode head) {
    	int l = 0;
    	
    	while (head != null) {
    		head = head.next;
    		l++;
    	}
    	
    	return l;
    }
    
    private ListNode getNode(ListNode head, int index) {
    	while (index > 0) {
    		head = head.next;
    		index--;
    	}
    	
    	return head;
    }
    
    private ListNode merge(ListNode p1, ListNode p2, int len) {
    	ListNode dummy = new ListNode(0);
    	ListNode p = dummy;
    	int l1 = 0;
    	int l2 = 0;
    	while (l1 < len/2 && l2 < len - len/2) {
    		if (p1.val < p2.val) {
    			p.next = p1;
    			p1 = p1.next;
    			p = p.next;
    			l1++;
    		} else {
    			p.next = p2;
    			p2 = p2.next;
    			p = p.next;
    			l2++;
    		}
    	}
    	if (l1 == len/2) {
    		p.next = p2;
    	} else {
    		p.next = p1;
    	}
    	return dummy.next;
    }
    
    private void addTail(ListNode head, int n) {
    	while (n > 1) {
    		head = head.next;
    		n--;
    	}
    	head.next = null;
    }
}