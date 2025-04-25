import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		int[] dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			dp[i] = Integer.parseInt(st.nextToken()) + dp[i - 1];
		
		int answer = Integer.MIN_VALUE;
		for (int i = K; i < dp.length; i++) {
			answer = Integer.max(dp[i] - dp[i - K], answer);
		}
		
		System.out.println(answer);
	}
}
