import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N, M;
  static ArrayList<ArrayList<Integer>> graph, reverseGraph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    N = Integer.parseInt(nm[0]);
    M = Integer.parseInt(nm[1]);
    graph = new ArrayList<>();
    reverseGraph = new ArrayList<>();
    visited = new boolean[N + 1];

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Integer>());
      reverseGraph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; i++) {
      String[] row = br.readLine().split(" ");
      int a = Integer.parseInt(row[0]);
      int b = Integer.parseInt(row[1]);
      graph.get(a).add(b);
      reverseGraph.get(b).add(a);
    }

    int answer = 0;
    for (int i = 1; i <= N; i++) {
      bfs(i, true);
      bfs(i, false);
      boolean isNotConnected = false;
      for (int j = 1; j <= N; j++) {
        if (visited[j] == false) {
          isNotConnected = true;
          break;
        }
      }

      visited = new boolean[N + 1];
      answer = isNotConnected ? answer : answer + 1;
    }

    System.out.println(answer);
  }

  // 노드 탐색
  static void bfs(int node, boolean isReverse) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    while (queue.isEmpty() == false) {
      int newNode = queue.poll();
      visited[newNode] = true;
      ArrayList<Integer> g = isReverse ? reverseGraph.get(newNode) : graph.get(newNode);
      for (int next : g) {
        if (visited[next])
          continue;

        visited[next] = true;
        queue.offer(next);
      }
    }
  }
}
