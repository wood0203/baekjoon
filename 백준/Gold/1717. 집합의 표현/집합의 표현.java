import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] parent;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if (x == y) return false;
		
		if (x <= y) parent[y] = x;
		else parent[x] = y;
		
		return true;
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			if (input[0].equals("0")) {
				union(a, b);
			} else {
				if (find(a) == find(b))
					sb.append("yes").append("\n");
				else
					sb.append("no").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}