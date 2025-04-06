import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N, K;
	static int[] dp = new int[200000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		N = Integer.parseInt(nk[0]);
		K = Integer.parseInt(nk[1]);
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {N, 0});
		int answer = 0;
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			if (p[0] == K) {
				answer = p[1];
				break;
			}
			
			if (check(p[0] - 1) && dp[p[0] - 1] == 0) {
				dp[p[0] - 1] = p[1] + 1;
				queue.offer(new int[] {p[0] - 1, p[1] + 1});
			}
			if (check(p[0] + 1) && dp[p[0] + 1] == 0) {
				dp[p[0] + 1] = p[1] + 1;
				queue.offer(new int[] {p[0] + 1, p[1] + 1});
			}
			if (check(p[0] * 2) && dp[p[0] * 2] == 0) {
				dp[p[0] * 2] = p[1] + 1;
				queue.offer(new int[] {p[0] * 2, p[1] + 1});
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean check(int index) {
		return (0 <= index && index < dp.length);
	}

}