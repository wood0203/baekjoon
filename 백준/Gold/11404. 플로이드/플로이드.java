import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], 20000000);
			dist[i][i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken());
			dist[start][end] = Integer.min(value, dist[start][end]);
		}
		
		for (int mid = 0; mid < N; mid++) {
			for (int start = 0; start < N; start++) {
				for (int end = 0; end < N; end++) {
					if (start == end) continue;
					dist[start][end] = Integer.min(dist[start][end], dist[start][mid] + dist[mid][end]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] != 0 && dist[i][j] != 20000000)
					sb.append(dist[i][j]).append(" ");
				else
					sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
