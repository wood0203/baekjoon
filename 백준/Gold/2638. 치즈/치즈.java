import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        while (melt()) answer++;

        System.out.println(answer);
    }

    public static boolean melt() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited = new boolean[N][M];
        visited[0][0] = true;
        Queue<int[]> cheeses = new ArrayDeque<>();
        int[][] cnt = new int[N][M];
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (!check(nx, ny) || visited[nx][ny]) continue;

                if (board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                    continue;
                } else {
                    if (++cnt[nx][ny] == 2) {
                        cheeses.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        boolean isMelted = !cheeses.isEmpty();
        for (int[] cheese: cheeses) {
            board[cheese[0]][cheese[1]] = 0;
        }
        return isMelted;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}