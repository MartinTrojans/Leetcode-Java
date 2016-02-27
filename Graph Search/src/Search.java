
public class Search {
	public void DFS(int[][] edges, int v){
		int len = edges.length;
		int[] visited = new int[len];
		int[] stack = new int[len];
		int top = 0;
		int i = 0;
		stack[0] = v;
		visited[v] = 1;
		System.out.println(v);
		
		while (top != -1){
			v = stack[top];
			for (i = 0; i < len; i++){
				if (edges[v][i] == 1 && visited[i] == 0){
					System.out.println(i);
					stack[++top] = i;
					visited[i] = 1;
					break;
				}
			}
			if (i == len)//no child
				top--;
		}
	}
	
	public void BFS(int[][] edges, int v){
		int len = edges.length;
		int[] visited = new int[len];
		int[] queue = new int[len];
		int front = 0;
		int rear = 1;
		int i = 0;
		queue[0] = v;
		visited[v] = 1;
		System.out.println(v);
		
		while (rear > front){
			v = queue[(front++)%len];
			for (i = 0; i < len; i++){
				if (edges[v][i] == 1 && visited[i] == 0){
					System.out.println(i);
					queue[(rear++)%len] = i;
					visited[i] = 1;
				}
			}
		}
	}
}