
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		System.out.println(s.findItinerary(tickets));
	}

}
