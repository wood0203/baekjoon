import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		z(N, R, C);
		System.out.println(answer);
	}
	
	static void z(int n, int r, int c) {
		if (n == 0) {
			return;
		}

		int half = (int) Math.pow(2, n) / 2;
		int sum = half * half;
		if (r < half && c >= half) {
			answer += sum;
			z(n - 1, r, c - half);
		} else if (r >= half && c < half) {
			answer += (sum * 2);
			z(n - 1, r - half, c);
		} else if (r >= half && c >= half) {
			answer += (sum * 3);
			z(n - 1, r - half, c - half);
		} else {
			z(n - 1, r, c);
		}
	}

}
