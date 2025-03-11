import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static long A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ab = br.readLine().split(" ");
		 A = Long.parseLong(ab[0]);
		 B = Long.parseLong(ab[1]);
		 dfs(A, 0);
		 answer = answer == Integer.MAX_VALUE ? -1 : answer + 1;
		 System.out.println(answer);
	}
	
	static void dfs(long value, int cnt) {
		
		if (value == B) {
			answer = Integer.min(cnt, answer);
			return;
		}
		
		if (value > B) return;
		
		dfs(value * 2, cnt + 1);
		dfs(Long.parseLong(value + "1"), cnt + 1);
	}
}
