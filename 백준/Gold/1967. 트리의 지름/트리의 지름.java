import java.util.*;
import java.io.*;

public class Main {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N;
    static List<Edge>[] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        
        int x = bfs(1)[0];
        System.out.println(bfs(x)[1]);
    }

    static int[] bfs(int start) {
        visited = new boolean[N + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        visited[start] = true;
        int farNode = start;
        int farDist = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[1] > farDist) {
                farDist = p[1];
                farNode = p[0];
            }

            for (Edge e: edges[p[0]]) {
                if (visited[e.to]) continue;

                visited[e.to] = true;
                queue.offer(new int[] {e.to, p[1] + e.weight});
            }
        }

        return new int[] {farNode, farDist};
    } 
}