import java.util.*;
import java.io.*;

public class Main {

    static int N, M, W, INF = 987654321;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int tc = 0; tc < T; tc++) {
            String[] nmw = br.readLine().split(" ");
            N = Integer.parseInt(nmw[0]);
            M = Integer.parseInt(nmw[1]);
            W = Integer.parseInt(nmw[2]);
            dist = new int[N + 1];
            graph.clear();
            for (int i = 0; i <= N; i++)
                graph.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                String[] roadInput = br.readLine().split(" ");
                int s = Integer.parseInt(roadInput[0]);
                int e = Integer.parseInt(roadInput[1]);
                int t = Integer.parseInt(roadInput[2]);
                graph.get(s).add(new int[] {e, t});
                graph.get(e).add(new int[] {s, t});
            }

            for (int i = 0; i < W; i++) {
                String[] wormHole = br.readLine().split(" ");
                int s = Integer.parseInt(wormHole[0]);
                int e = Integer.parseInt(wormHole[1]);
                int t = Integer.parseInt(wormHole[2]);
                graph.get(s).add(new int[] {e, -t});
            }

            String answer = belmanford() ? "YES" : "NO";
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean belmanford() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update = false;
        for (int i = 1; i <= N; i++) {
            update = false;
            for (int j = 1; j <= N; j++) {
                for (int[] next: graph.get(j)) {
                    int newDist = dist[j] + next[1];
                    if (newDist < dist[next[0]]) {
                        dist[next[0]] = newDist;
                        update = true;
                    }
                }
            }

            if (!update) break;
        }

        if (update) {
            for (int j = 1; j <= N; j++) {
                for (int[] next: graph.get(j)) {
                    int newDist = dist[j] + next[1];
                    if (newDist < dist[next[0]]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}