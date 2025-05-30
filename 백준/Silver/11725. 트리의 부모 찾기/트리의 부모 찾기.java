import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		visited[1] = true;
		int[] answer = new int[n + 1];
		while (!queue.isEmpty()) {
			int p = queue.poll();
			for (int e: graph.get(p)) {
				if (visited[e]) continue;
				
				queue.offer(e);
				visited[e] = true;
				answer[e] = p;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(answer[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}