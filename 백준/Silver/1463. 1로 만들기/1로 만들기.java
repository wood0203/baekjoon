import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			if (i % 3 == 0) {
				dp[i] = Integer.min(dp[i / 3] + 1, dp[i]);
			}
			if(i % 2 == 0) {
				dp[i] = Integer.min(dp[i / 2] + 1, dp[i]);
			}
			dp[i] = Integer.min(dp[i - 1] + 1, dp[i]);
		}
		
		System.out.println(dp[N]);
	}
}
