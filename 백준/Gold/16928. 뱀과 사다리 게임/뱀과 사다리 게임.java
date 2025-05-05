import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Main {
	
	static HashMap<Integer, Integer> ladders = new HashMap<>();
	static HashMap<Integer, Integer> snakes = new HashMap<>();
	static int N, M, answer = 99;
	static boolean[] visited = new boolean[100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" "); 
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		for (int i = 0; i < N; i++) {
			String[] ab = br.readLine().split(" ");
			ladders.put(Integer.parseInt(ab[0]), Integer.parseInt(ab[1]));
		}
		
		for (int i = 0; i < M; i++) {
			String[] ab = br.readLine().split(" ");
			ladders.put(Integer.parseInt(ab[0]), Integer.parseInt(ab[1]));
		}
		
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {1, 0});
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			if (p[0] == 100) {
				System.out.println(p[1]);
				return;
			}
			
			if (visited[p[0]]) continue;
			
			int straight = 1;
			for (int i = 1; i <= 6; i++) {
				if (snakes.get(p[0] + i) != null) continue;
				
				if (ladders.get(p[0] + i) != null) {
					queue.offer(new int[] {ladders.get(p[0] + i), p[1] + 1});
					continue;
				}
				
				if (p[0] + i <= 100)
					straight = Integer.max(straight, i);
			}

			visited[p[0]] = true;
			queue.offer(new int[] {straight + p[0], p[1] + 1});
		}
	}
}
