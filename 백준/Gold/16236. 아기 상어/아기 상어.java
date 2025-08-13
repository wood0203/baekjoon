import java.util.*;
import java.io.*;

public class Main {

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish f) {
            if (dist == f.dist) {
                if (f.x == this.x) {                
                    return Integer.compare(this.y, f.y);
                }
                return Integer.compare(this.x, f.x);
            }

            return Integer.compare(this.dist, f.dist);
        }
    }

    static int N, curX, curY, level = 2, cnt = 2, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] room;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 9) {
                    curX = i;
                    curY = j;
                }
            }
        }

        while (true) {
            // 1. BFS로 이동하면서 자신보다 낮은 레벨의 가장 가까운 물고기들을 찾는다.
            // x가 낮을수록, x가 같으면 y가 작을수록 우선순위가 높음 => 우선순위 큐
            PriorityQueue<Fish> fishes = new PriorityQueue<>();
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];
            queue.offer(new int[] {curX, curY, 0});
            visited[curX][curY] = true;
            int minDist = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                if (p[2] > minDist) break;

                int curLvl = room[p[0]][p[1]];
                if (0 < curLvl && curLvl < level) {
                    Fish f = new Fish(p[0], p[1], p[2]);
                    fishes.offer(f);
                    minDist = p[2];
                }

                for (int i = 0; i < 4; i++) {
                    int nx = p[0] + dx[i];
                    int ny = p[1] + dy[i];
                    if (check(nx, ny) && !visited[nx][ny]) {
                        if (0 <= room[nx][ny] && room[nx][ny] <= level) {
                            queue.offer(new int[] {nx, ny, p[2] + 1});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            if (fishes.isEmpty()) break;

            // 2. 해당 위치로 이동 => 이동거리 +
            // 만약 해당 위치로 이동 경로 dfs 계산해서 못 가면 이동 X
            Fish fish = fishes.peek();
            // System.out.println(fish.x + " " + fish.y + " " + fish.dist);
            room[curX][curY] = 0;
            curX = fish.x;
            curY = fish.y;
            room[curX][curY] = 0;
            answer += fish.dist;

            // 3. 해당 칸을 0으로 바꾸고 cnt--
            cnt--;

            // 4. 만약 cnt가 0이되면 level++
            if (cnt == 0) {
                level++;
                cnt = level;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}