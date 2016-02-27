
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(0);
		//head.next.next.next.next.next = new ListNode(6);
		//head.next.next.next.next.next.next = new ListNode(23);
		//head.next.next.next.next.next.next.next = new ListNode(8);
		head = s.sortList(head);
		ListNode p = head;
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}

}
