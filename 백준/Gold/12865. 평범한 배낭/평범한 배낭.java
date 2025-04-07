import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N, K;
	static int[][] dp;
	static int[][] backpacks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		N = Integer.parseInt(nk[0]);
		K = Integer.parseInt(nk[1]);
		dp = new int[N + 1][K + 1];
		backpacks = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			backpacks[i][0] = Integer.parseInt(input[0]);
			backpacks[i][1] = Integer.parseInt(input[1]);
		}

		int answer = 0;
		for (int i = 1; i < backpacks.length; i++) {
			int weight = backpacks[i][0];
			int value = backpacks[i][1];
			for (int j = 0; j <= K; j++) {
				if (j < weight) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Integer.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
				}
				answer = Integer.max(dp[i][j], answer);
			}
		}
		
		System.out.println(answer);
	}
}
