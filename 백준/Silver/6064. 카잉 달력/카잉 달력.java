import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			long end = M * N / gcd(Integer.max(M, N), Integer.min(M, N));
			HashSet<Long> indexes = new HashSet<>();
			long value = x;
			indexes.add(value);
			while (value <= end) {
				value += M;
				indexes.add(value);
			}
			
			long answer = -1;
			long value2 = y;
			while (value2 <= end) {
				if (indexes.contains(value2)) {
					answer = value2;
				}
				value2 += N;
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;

		return gcd(b, a % b);
	}

}
