import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long answer = 0;
	static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		trees = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		pmSearch(0, trees[N - 1]);
		System.out.println(answer);
	}
	
	static void pmSearch(int start, int end) {
		int mid = (start + end) / 2;
		long total = cut(mid);
		if (total >= M)
			answer = Long.max(answer, mid);
		
		if (start >= end) {
			return;
		}
		
		if (total >= M) {
			pmSearch(mid + 1, end);
		} else {
			pmSearch(start, mid - 1);
		}
	}
	
	static long cut(int height) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (trees[i] > height)
				sum += (trees[i] - height);
		}
		return sum;
	}
}