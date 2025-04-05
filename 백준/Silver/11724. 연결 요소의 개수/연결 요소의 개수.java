import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		parents = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			parents[i] = i;
		
		for (int i = 0; i < M; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			union(a, b);
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			find(i);
			if (i == parents[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) return false;
		
		if (pa <= pb)
			parents[pb] = pa;
		else
			parents[pa] = pb;
		return true;
	}
	
	static int find(int x) {
		if (x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}

}
