import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		
		for (int i = 0; i < M; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		
		int[] answer = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
		for (int i = N; i > 0; i--) {
			int value = bfs(i);
			if (value == answer[1]) {
				answer[0] = i;
			} else if (value < answer[1]) {
				answer[0] = i;
				answer[1] = value;
			}
		}
		
		System.out.println(answer[0]);
	}
	
	static int bfs(int start) {
		boolean[] visited = new boolean[N + 1];
		visited[0] = true;
		visited[start] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {start, 0});
		int total = 0;
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int node: graph.get(p[0])) {
				if (visited[node]) continue;
				
				total += (p[1] + 1);
				visited[node] = true;
				queue.offer(new int[] {node, p[1] + 1});
			}
		}
		
		return total;
	}
}