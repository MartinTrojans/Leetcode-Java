
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode head = new ListNode(2);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(5);
		head = s.insertionSortList(head);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
