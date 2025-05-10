import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, B;
	static int[][] grounds;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmb = br.readLine().split(" ");
		N = Integer.parseInt(nmb[0]);
		M = Integer.parseInt(nmb[1]);
		B = Integer.parseInt(nmb[2]);
		grounds = new int[N][M];
		int maxHeight = Integer.MIN_VALUE;
		int minHeight = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				grounds[i][j] = h;
				maxHeight = Math.max(maxHeight, h);
				minHeight = Math.min(minHeight, h);
			}
		}
		
		int[] answer = new int[] {0, Integer.MAX_VALUE};
		for (int target = minHeight; target <= maxHeight; target++) {
			int temp = 0;
			int time = 0;
			int remainCnt = B;
			// 깎는거 먼저
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grounds[i][j] > target) {
						remainCnt += grounds[i][j] - target;
						temp += grounds[i][j] - target;
						time += (grounds[i][j] - target) * 2;
					}
				}
			}
			
			// 쌓기
			
			boolean cant = false;
			Outter:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grounds[i][j] < target) {
						if (remainCnt < target - grounds[i][j]) {
							cant = true;
							break Outter;
						}

						remainCnt -= target - grounds[i][j];
						temp += target - grounds[i][j];
						time += (target - grounds[i][j]);
					}
				}
			}
			
			if (cant) continue;
			
			if (time <= answer[1]) {
				answer[1] = Math.min(time, answer[1]);
				answer[0] = Math.max(target, answer[0]);
			}
		}
		
		System.out.println(answer[1] + " " + answer[0]);
	}
}