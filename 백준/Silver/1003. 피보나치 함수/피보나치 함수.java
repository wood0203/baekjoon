import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(dp[input][0]).append(" ").append(dp[input][1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}