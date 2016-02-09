
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		s.deleteDuplicates(head);
		System.out.println(head);
	}

}
