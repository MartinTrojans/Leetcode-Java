import java.util.Set;
import java.util.HashSet;

public class ShortestPath {
	  // Dijkstra's algorithm to find shortest path from s to all other nodes
	public static void dijkstra(int[][] edges, int s, int[] dist, int[] pre) {
		int n = edges.length;
		
		HashSet<Integer> set = new HashSet<Integer>(n);
		
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			set.add(i);
		}
		dist[s] = 0;
		
		while (!set.isEmpty()) {
			int min = findMin(set, dist);
			for (int i = 0; i < n; i++) {
				if (edges[min][i] != -1) { // find the neighbors of the node
					if (dist[i] < dist[min] + edges[min][i]) { //relaxation
						dist[i] = dist[min] + edges[min][i];
						pre[i] = min;
					}
				}
			}
		}
	}
	private static int findMin(Set set, int[] dist) {
		int min = Integer.MAX_VALUE, minIdx = -1;
		for (int i = 0; i < dist.length; i++) {
			if (set.contains(i) && dist[i] < min) {
				min = dist[i];
				minIdx = i;
			}
		}
		set.remove(minIdx);
		return minIdx;
	}
}
