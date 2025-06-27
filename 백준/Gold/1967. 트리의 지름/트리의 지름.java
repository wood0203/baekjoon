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

    static int N, answer;
    static List<Edge>[] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
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

        dfs(1);
        System.out.println(answer);
    }

    static int dfs(int start) {
        visited[start] = true;

        int max1 = 0;
        int max2 = 0;
        for (Edge e: edges[start]) {
            if (visited[e.to]) continue;

            int dist = dfs(e.to) + e.weight;
            if (dist > max1) {
                max2 = max1;
                max1 = dist;
            } else if (dist > max2) {
                max2 = dist;
            }
        }

        answer = Integer.max(answer, max1 + max2);
        return max1;
    }
}