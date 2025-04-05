import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] cnt;
	static int[][] papers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = new int[2];
		papers = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(0, 0, N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}
	
	static void check(int x, int y, int size) {
		boolean isAllSame = true;
		Outter:
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (papers[x][y] != papers[i][j]) {
					isAllSame = false;
					break Outter;
				}
			}
		}
		
		if (isAllSame) {
			cnt[papers[x][y]] += 1;
		} else {
			int half = size / 2;
			check(x, y, half);
			check(x, y + half, half);
			check(x + half, y, half);
			check(x + half, y + half, half);
		}
	}

}
