import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        
        int index;
        int weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[] {end, weight});
        }

        String[] se = br.readLine().split(" ");
        int start = Integer.parseInt(se[0]);
        int end = Integer.parseInt(se[1]);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (curNode.index == end) {
                System.out.println(curNode.weight);
                return;
            }

            if (visited[curNode.index]) continue;

            visited[curNode.index] = true;

            if (curNode.weight > dist[curNode.index]) continue;

            for (int[] next: graph.get(curNode.index)) {
                int newWeight = curNode.weight + next[1];
                if (newWeight < dist[next[0]]) {
                    dist[next[0]] = newWeight;
                    pq.offer(new Node(next[0], newWeight));
                }

            }
        }

    }

}
