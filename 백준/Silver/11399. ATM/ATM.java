import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] times = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
			dp[i + 1] = times[i];
		}
		
		Arrays.sort(times);
		int total = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1] + times[i - 1];
			total += dp[i];
		}
		
		System.out.println(total);
	}

}
