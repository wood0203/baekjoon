import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, answer = Integer.MAX_VALUE;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] board;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		board = new int[N][M];
		visited = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				int value = Character.getNumericValue(input[j]);
				board[i][j] = value;
			}
		}
		
		bfs();
		answer = answer == Integer.MAX_VALUE ? -1 : answer;
		System.out.println(answer);
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0, 1, 0});
		visited[0][0][0] = true;
		while (queue.isEmpty() == false) {
			int[] p = queue.poll();
			if (p[0] == N - 1 && p[1] == M - 1) {
				answer = Integer.min(answer, p[3] + 1);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				if (!check(nx, ny) || visited[nx][ny][p[2]])
					continue;
				
				if (board[nx][ny] == 1 && !visited[nx][ny][1]) {
					if (p[2] == 0) continue;
					
					visited[nx][ny][1] = true;
					queue.offer(new int[] {nx, ny, 0, p[3] + 1});
				} else if (board[nx][ny] == 0) {
					visited[nx][ny][p[2]] = true;
					queue.offer(new int[] {nx, ny, p[2], p[3] + 1});
				}
			}
		}
	}
	
	static boolean check(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < M);
	}
}