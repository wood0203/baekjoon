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
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			int year = x;
			int maxValue = M * N / gcd(M, N);
			int answer = -1;
			while (year <= maxValue) {
				if (year % N == y) {
					answer = year + 1;
					break;
				}
				
				year += M;
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		
		return gcd(b, a % b);
	}


}
