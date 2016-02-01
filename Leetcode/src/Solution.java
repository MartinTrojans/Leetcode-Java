import java.util.ArrayList;
import java.util.List;
/*
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
		List<Integer> l = new ArrayList<Integer>();
    	ListNode p = head;
		while(p != null){
			l.add(p.val);
			p = p.next;
		}
		Integer[] a = (Integer[])l.toArray(new Integer[0]);
		int size = a.length;
    	return df(0, size-1, a);
    }
    private TreeNode df(int low, int high, Integer[] a){
    	if(low > high){
    		return null;
    	}
		int mid = (low + high) / 2;
		TreeNode mn = new TreeNode(a[mid]);
		mn.left = df(low, mid-1, a);
		mn.right = df(mid+1, high, a);
    	return mn;
    }
}

public class Solution {
	static ListNode p;
    public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		p = head;
		int size = getLength(head);
		return df(0, size-1);
    }
    
    private int getLength(ListNode p){
    	int l = 0;
    	while(p != null){
    		p = p.next;
    		l++;
    	}
    	return l;
    }
    private TreeNode df(int low, int high){
    	if(low > high){
    		return null;
    	}
		int mid = (low + high) / 2;
		TreeNode left = df(low, mid-1);
		TreeNode mn = new TreeNode(p.val);
		p = p.next;
		mn.right = df(mid+1, high);
		mn.left = left;
    	return mn;
    }
}
*/

public class Solution {
    ListNode getLeftNodeFromList(ListNode head) {
        ListNode next = head;
        ListNode current = head; 
        ListNode pre = head;

        while(next!=null) {
            next = next.next;
            if(next==null) {
                break;
            }
            next = next.next;
            if(next==null) {
                break;
            }
            pre = head;
            head = head.next;
        }
        return pre;
    }
    
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return new TreeNode(head.val);
        }
        
        ListNode left = getLeftNodeFromList(head);
        ListNode mid = left.next;
        TreeNode root = new TreeNode(mid.val);
        left.next     = null;
        root.left     = sortedListToBST(head);
        root.right    = sortedListToBST(mid.next);
        return root;
    }
}