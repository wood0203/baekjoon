import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, M, answer = 0;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
			
		for (int i = 0; i < M; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			graph[a][b] = graph[b][a] = 1;
		}
		
		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[1] = true;
		queue.offer(1);
		
		while (queue.isEmpty() == false) {
			int p = queue.poll();
			for (int i = 2; i <= N; i++) {
				if (visited[i] || graph[p][i] == 0) continue;

				
				visited[i] = true;
				queue.offer(i);
				answer++;
			}
		}
	}
}
