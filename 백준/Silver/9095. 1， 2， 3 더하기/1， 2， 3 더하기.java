import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(solution(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int solution(int n) {
		if (dp[n] != 0) {
			return dp[n];
		}
		
		return solution(n - 1) + solution(n - 2) + solution(n - 3);
	}

}
