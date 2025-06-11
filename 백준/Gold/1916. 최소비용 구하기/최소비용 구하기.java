import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        
        int index;
        int dist;

        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dist = new int[N + 1];
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new int[] {end, weight});
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
                System.out.println(curNode.dist);
                return;
            }

            if (curNode.dist > dist[curNode.index]) continue;

            for (int[] next: graph[curNode.index]) {
                int newWeight = curNode.dist + next[1];
                if (newWeight < dist[next[0]]) {
                    dist[next[0]] = newWeight;
                    pq.offer(new Node(next[0], newWeight));
                }

            }
        }

    }

}
