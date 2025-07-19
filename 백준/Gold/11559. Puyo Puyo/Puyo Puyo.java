import java.util.*;
import java.io.*;

public class Main {

    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                field[i][j] = row[j];
            }
        }

        int answer = 0;
        while (puyo()) {
            answer++;
        }
        System.out.println(answer);
    }

    static boolean puyo() {
        visited = new boolean[12][6];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j] == '.' || visited[i][j]) continue;

                visited[i][j] = true;
                ArrayDeque<int[]> tempQ = new ArrayDeque<>();
                tempQ.offer(new int[] {i, j});
                queue.offer(new int[] {i, j});
                int cnt = 1;
                // 1. 터트릴 뿌요를 탐색
                while (!tempQ.isEmpty()) {
                    int[] p = tempQ.poll();
                    
                    for (int k = 0; k < 4; k++) {
                        int nx = p[0] + dx[k];
                        int ny = p[1] + dy[k];
                        if (!check(nx, ny) || visited[nx][ny] || field[nx][ny] != field[i][j]) continue;

                        visited[nx][ny] = true;
                        cnt++;
                        tempQ.offer(new int[] {nx, ny});
                        queue.offer(new int[] {nx, ny});
                    }
                }

                if (cnt < 4) {
                    for (int z = 0; z < cnt; z++) queue.pollLast();
                }
            }
        }

        if (queue.isEmpty()) return false;

        // 2. 연쇄 터트리기
        for (int[] p: queue) {
            field[p[0]][p[1]] = '.';
        }

        // 3. 뿌요 재배치
        // 3-1. 최하단 '.' 을 찾는다.
        // 3-2. 문자를 해당 위치로 옮긴다.
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (field[j][i] != '.') continue;

                for (int k = j - 1; k >= 0; k--) {
                    if (field[k][i] != '.') {
                        field[j][i] = field[k][i];
                        field[k][i] = '.';
                        break;
                    }
                }
            }
        }

        return true;
    }

    static boolean check(int x, int y) {
        return 0 <= x && x < 12 && 0 <= y && y < 6;
    }
}