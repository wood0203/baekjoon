import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	
	static class Node implements Comparable<Node> {
		int num;
		int weight;
		
		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(weight, n.weight);
		}
	}
	
	static int N, M;
	static int[] dist;
	static ArrayList<int[]>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		int start = Integer.parseInt(br.readLine());
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[start] = 0;
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			String[] sew = br.readLine().split(" ");
			int from = Integer.parseInt(sew[0]);
			int to = Integer.parseInt(sew[1]);
			int weight = Integer.parseInt(sew[2]);
			graph[from].add(new int[] { to, weight });
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			visited[n.num] = true;

			for (int[] next: graph[n.num]) {
				if (visited[next[0]]) continue;
				
				int newDist = dist[n.num] + next[1];
				if (newDist < dist[next[0]]) {
					pq.offer(new Node(next[0], newDist));
					dist[next[0]] = newDist;
				}
			}
		}
		

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}