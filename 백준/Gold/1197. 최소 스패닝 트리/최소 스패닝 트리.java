import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static int[] parents;
	static Edge[] edges;
	
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
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ve = br.readLine().split(" ");
		V = Integer.parseInt(ve[0]);
		E = Integer.parseInt(ve[1]);
		parents = new int[V + 1];
		edges = new Edge[E];
		
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edges);
		
		int answer = 0;
		int cnt = 0;
		for (Edge e: edges) {
			if (union(e.start, e.end) == false)
				continue;
			
			answer += e.weight;
			
			if (++cnt == V - 1)
				break;
		}
		
		System.out.println(answer);
	}
	
}
