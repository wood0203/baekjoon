import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited[1] = true;
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int count = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 1, 0 });
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			
			if (p[1] == 2)
				continue;

			for (int node: graph.get(p[0])) {
				if (visited[node])
					continue;
				
				visited[node] = true;
				count++;
				queue.add(new int[] { node, p[1] + 1});
			}
		}
		
		return count;
	}
}
