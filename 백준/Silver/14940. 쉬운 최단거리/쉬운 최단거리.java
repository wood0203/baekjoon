import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					map[i][j] = 0;
					visited[i][j] = true;
					queue.offer(new int[] {i, j, 0});
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = p[0] + dx[k];
				int ny = p[1] + dy[k];
				if (check(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					map[nx][ny] = p[2] + 1;
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny, p[2] + 1});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					sb.append(-1).append(" ");
				} else {
					sb.append(map[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean check(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < M);
	}
}
