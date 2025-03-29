import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	static int N;
	static int[][] results;
	static int[] orders = new int[9];
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		results = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int result = Integer.parseInt(st.nextToken());
				results[i][j] = result;
			}
		}
		
		visited[0] = true;
		perm(0);
		System.out.println(answer);
	}
	
	// 순열 코드
	static void perm(int cnt) {
		if (cnt == 9) {
			answer = Integer.max(answer, play());
			return;
		}
		
		if (cnt == 3) {
			perm(cnt + 1);
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			
			visited[i] = true;
			orders[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
			orders[cnt] = 0;
		}
	}
	
	// play
	static int play() {
		int totalScore = 0;
		int outCnt = 0;
		int currentOrder = 0;
		Queue<Integer> baseQueue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			while (outCnt < 3) {
				// 아웃일 때
				int score = results[i][orders[currentOrder]];
				if (score == 0) {
					outCnt++;
				} else {
					int queueSize = baseQueue.size();
					for (int k = 0; k < queueSize; k++) {
						int base = baseQueue.poll() + score;
						if (base >= 4) {
							totalScore++;
						} else {
							baseQueue.offer(base);
						}
					}

					// 현재 타자 큐에 추가하는데, 홈런이면 추가 X
					if (score == 4) {
						totalScore++;
					} else {
						baseQueue.offer(score);
					}
				}
				currentOrder = currentOrder < 8 ? currentOrder + 1 : 0;
			}
			baseQueue.clear();
			outCnt = 0;
		}
		
		return totalScore;
	}
}
