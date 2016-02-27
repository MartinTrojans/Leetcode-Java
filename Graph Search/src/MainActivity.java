
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search s = new Search();
		int[][] edges = {
				{0, 1, 1, 1, 0},
				{1, 0, 0, 0, 0},
				{1, 0, 0, 1, 1},
				{1, 0, 1, 0, 0},
				{0, 0, 1, 0, 0}
		};
		System.out.println("BFS:");
		s.BFS(edges, 0);

		System.out.println("DFS:");
		s.DFS(edges, 0);
	}

}
