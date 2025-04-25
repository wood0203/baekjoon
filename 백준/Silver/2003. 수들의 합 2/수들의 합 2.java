import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken());
			dp[i] = dp[i - 1] + value;
		}
		
		int start = 1;
		int end = 1;
		int answer = 0;
		while (start <= N) {
			if (end >= N) {
				int cur = dp[end] - dp[start - 1];
				if (cur == M) answer++;
				start += 1;
				continue;
			}
			

			int cur = dp[end] - dp[start - 1];
			if (cur > M)
				start += 1;
			else if (cur < M)
				end += 1;
			else {
				start += 1;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
