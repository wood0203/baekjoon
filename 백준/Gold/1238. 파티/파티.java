import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
            int index;
            int time;

            Node(int index, int time) {
                this.index = index;
                this.time = time;
            }

            @Override
            public int compareTo(Node n) {
                return Integer.compare(this.time, n.time);
            }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] dist = new int[N + 1];
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        ArrayList<int[]>[] rGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(input.nextToken());
            int end = Integer.parseInt(input.nextToken());
            int weight = Integer.parseInt(input.nextToken());
            graph[start].add(new int[] {end, weight});
            rGraph[end].add(new int[] {start, weight});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (int[] next: graph[curNode.index]) {
                int nextTime = curNode.time + next[1];
                if (dist[next[0]] < nextTime) continue;

                dist[next[0]] = nextTime;
                pq.offer(new Node(next[0], nextTime));
            }
        }

        pq.clear();
        int[] rDist = new int[N + 1];
        Arrays.fill(rDist, Integer.MAX_VALUE);
        rDist[X] = 0;
        pq.offer(new Node(X, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (int[] next: rGraph[curNode.index]) {
                int nextTime = curNode.time + next[1];
                if (rDist[next[0]] < nextTime) continue;

                rDist[next[0]] = nextTime;
                pq.offer(new Node(next[0], nextTime));
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            if (i == X) continue;

            int sum = rDist[i] + dist[i];
            answer = Integer.max(answer, sum);
        }

        System.out.println(answer);

    }

}