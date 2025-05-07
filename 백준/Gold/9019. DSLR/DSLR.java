import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// start at 14:32
// end	 at 15:20

public class Main {
	
	static int N, start, target;
	static String[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			visited = new String[10000];
			String[] input = br.readLine().split(" ");
			start = Integer.parseInt(input[0]);
			target = Integer.parseInt(input[1]);
			visited[start] = "";
			convert();
			sb.append(visited[target]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void convert() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int p = queue.poll();
			// target과 같으면 
			if (p == target) return;
			
			// D 변환
			int dValue = (p * 2) % 10000;
			if (visited[dValue] == null) {
				visited[dValue] = visited[p] + "D";
				queue.offer(dValue);
			}
			
			// S 변환
			int sValue = p == 0 ? 9999 : p - 1;
			if (visited[sValue] == null) {
				visited[sValue] = visited[p] + "S";
				queue.offer(sValue);
			}

			// L 변환
			int lValue = p >= 1000 ? ((p * 10) % 10000) + (p / 1000) : p * 10;
			if (visited[lValue] == null) {
				visited[lValue] = visited[p] + "L";
				queue.offer(lValue);
			}
			
			// R 변환
			int rValue = (p % 10) * 1000 + (p / 10);
			if (visited[rValue] == null) {
				visited[rValue] = visited[p] + "R";
				queue.offer(rValue);
			}
		}
	}

}