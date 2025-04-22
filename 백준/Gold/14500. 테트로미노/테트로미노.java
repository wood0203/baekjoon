import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] scores;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		scores = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer = Integer.max(solution(i, j), answer);
			}
		}
		
		System.out.println(answer);
	}
	
	public static int solution(int x, int y) {
		int score = 0;
		// ----
		if (y <= M - 4) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x][y + 1]);
			temp += (scores[x][y + 2]);
			temp += (scores[x][y + 3]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 4) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 2][y]);
			temp += (scores[x + 3][y]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y <= M - 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x][y + 1]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 1][y + 1]);
			score = Integer.max(score, temp);			
		}
		
		if (x <= N - 3 && y <= M - 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 2][y]);
			temp += (scores[x + 2][y + 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 3 && y >= 1) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 2][y]);
			temp += (scores[x + 2][y - 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y <= M - 3) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x][y + 1]);
			temp += (scores[x][y + 2]);
			temp += (scores[x + 1][y]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y >= 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x][y - 1]);
			temp += (scores[x][y - 2]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 3 && y <= M - 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 2][y]);
			temp += (scores[x][y + 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 3 && y >= 1) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 2][y]);
			temp += (scores[x][y - 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y <= M - 3) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 1][y + 1]);
			temp += (scores[x + 1][y + 2]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y >= 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 1][y - 1]);
			temp += (scores[x + 1][y - 2]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 3 && y <= M - 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 1][y + 1]);
			temp += (scores[x + 2][y + 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 3 && y >= 1) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 1][y - 1]);
			temp += (scores[x + 2][y - 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y >= 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x][y - 1]);
			temp += (scores[x + 1][y - 1]);
			temp += (scores[x + 1][y - 2]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y <= M - 3) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x][y + 1]);
			temp += (scores[x + 1][y + 1]);
			temp += (scores[x + 1][y + 2]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y <= M - 3) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x][y + 1]);
			temp += (scores[x][y + 2]);
			temp += (scores[x + 1][y + 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 3 && y <= M - 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 2][y]);
			temp += (scores[x + 1][y + 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 2 && y > 0 && y <= M - 2) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y - 1]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 1][y + 1]);
			score = Integer.max(score, temp);
		}
		
		if (x <= N - 3 && y >= 1) {
			int temp = 0;
			temp += (scores[x][y]);
			temp += (scores[x + 1][y]);
			temp += (scores[x + 2][y]);
			temp += (scores[x + 1][y - 1]);
			score = Integer.max(score, temp);
		}
		
		return score;
	}

}
